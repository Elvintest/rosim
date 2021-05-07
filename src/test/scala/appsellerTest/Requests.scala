package appsellerTest

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.core.json.JsonParsers
import  scala.util.Random



object Requests {

  def randomString(length: Int) = {  // генерируем рандомные строки для данных
    val r = new scala.util.Random
    val sb = new StringBuilder
    for (i <- 1 to length) {
      sb.append(r.nextPrintableChar)
    }
    sb.toString
  }

  val randomNumber = scala.util.Random // генерируем рандомный int

  val users = csv("./src/test/resources/data/users.csv").circular // users for loading
  val outlets = csv("./src/test/resources/data/outlets.csv").circular // outlets
  val ports = collection.mutable.Map("ADDRESS" -> "30902", "AUTH" -> "30904", "REPORT" -> "30905", "TELEDEALER" -> "30906", "SIM"-> "30901", "SMS"-> "30903") // services ports


  val addressSearchString = http("listCountries") // getting countries by string
    .get(ports("ADDRESS") + s"/secured/address/country?characters=" + randomString(3))
    .check(status.is(200))

  val addressSearchCode = http("listCountries") // searching address by code
    .get(ports("ADDRESS") + s"/secured/address/country/" + randomString(6))
    .check(status.is(200))

  val login = feed(users) // data from users.csv, login
    .exec(http("Login")
      .post(ports("AUTH") + "/public/auth/login").body(StringBody(
      """{
        |
        |    "phoneNumber": "${log}",
        |
        |    "password": "${pass}",
        |
        |    "deviceId": "the_second_one"
        |}""".stripMargin)).asJson
      .check(status.is(200))
      .check(jmesPath("data.token").saveAs("token")) //extracting token from login response
    )
  val userInfo = http("userInfo") // getting user profile info

    .get(ports("AUTH") + "/secured/user/")
    .header("Authorization", "Bearer " + "${token}")
    .check(status.is(200))
  val swapOutlet = feed(outlets) // data from outlets.csv, outlet
    .exec(http("swapOutlet") // changing user's outlet
    .put(ports("AUTH") + "/secured/user/change/outlet").body(StringBody(
    """ ${outlet}
      """.stripMargin)).asJson
    .header("Authorization", "Bearer " + "${token}")
    .check(status.is(200))
    )

  val refreshToken = http("userInfo") // getting user profile info

    .post(ports("AUTH") + "/public/auth/token/refresh").body(StringBody(
    """{
      "accessToken":"${token}"
      }""".stripMargin)).asJson
    .check(status.is(200))

  val logEvent = http("userInfo") // registration some events
    .post(ports("REPORT") + "/secured/log/event").body(StringBody(
    """{
          "eventType": "SELL_ATTEMPT",
    "eventDateTime": "2021-04-23T12:43:06.164Z",
    "geolocation": "test_geolocation",
    "addInformationField": "test_information"
      }""".stripMargin)).asJson
    .check(status.is(200))
    .header("Authorization", "Bearer " + "${token}")

  val listDocuments = http("listDocuments") // get list mandatory docs
    .get(ports("TELEDEALER") + "/public/fs/template_document/list")
    .check(status.is(200))

  val checkCode = feed(users) // data from users.csv
    .exec(http("checkCode") // checking sms code
    .get(ports("SMS") + "/public/sms/check/code?code=" + randomNumber.nextInt(10000) + "&msisdn=${log}")
    .check(status.is(200))
    )
  val simAllowance = http("simAllowance") // checking a sim allowance for sale

    .post(ports("SIM") + "/secured/simcard/saleAvailable/check").body(StringBody(
    s"""{
    "name":${randomString(6)},
    "surname":${randomString(6)},
    "documentNumber":${randomString(6)}
}""".stripMargin)).asJson
    .header("Authorization", "Bearer " + "${token}")
    .check(status.is(200))

  val logout = http("logout") // execute logout
    .get(ports("AUTH") + "/secured/auth/logout")
    .header("Authorization", "Bearer " + "${token}")
    .check(status.is(200))
}


