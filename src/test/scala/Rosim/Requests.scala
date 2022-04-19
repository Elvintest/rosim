package Rosim

import io.gatling.core.Predef._
import io.gatling.http.Predef._


object Requests {

  val users = csv("./src/test/resources/data/users.csv").circular // users for loading
  val outlets = csv("./src/test/resources/data/outlets.csv").circular // outlets
  val ports = collection.mutable.Map("ADDRESS" -> "30902", "AUTH" -> "30904", "REPORT" -> "30905", "TELEDEALER" -> "30906", "SIM" -> "30901", "SMS" -> "30903") // services ports


  //Rosim requests
  val accessibleDatesBudjet = http("accessibleDatesBudget")
    .get("/public/dashboard/objectsInBudgetDates")
    .check(status.is(200))

  val accibleDatesTurnOver = http("accibleDatesTurnOver")
    .get("/public/dashboard/objectsInTurnoverDates")
    .check(status.is(200))

  val dashboardObjectsInTreasuryNoParameters = http("objectsInTreasury")
    .get("/public/dashboard/objectsInTreasury")
    .check(status.is(200))

  val dashboardObjectsInTreasuryWIthParameters = feed(Array(
    Map("from" -> s"2020-11-08", "to" -> s"2022-11-09"),
    Map("from" -> s"2020-12-12", "to" -> s"2021-11-09")
  ).circular)
    .exec(http("objectsInTreasury")
      .get("/public/dashboard/objectsInTreasury?dateFrom=${from}&dateTo=${to}")
      .check(status.is(200)))


  val rentContractDates = http("rentContractDates")
    .get("/public/dashboard/rentContractDates")
    .check(status.is(200))

  val privatizedObjectDates = http("privatizedObjectDates")
    .get("/public/dashboard/privatizedObjectsDates")
    .check(status.is(100))

  val dashboardObjectsBudget = feed(Array(
    Map("year" -> "2019"),
    Map("year" -> "2020")
  ).circular)
    .exec(http("dashboardObjectsBudget")
      .get("/public/dashboard/objectsInBudget?year=${year}")
      .check(status.is(200)))


  val objectsInTurnover = http("objectsInTurnover")
    .get("/public/dashboard/objectsInTurnover?year=2022")
    .check(status.is(200))

  val dashBoardRentContracts = http("dashBoardRentContracts")
    .get("/public/dashboard/rentContracts?date=2021-11-08")
    .check(status.is(200))

  val dashboardPrivatizedObjects = http("dashboardPrivatizedObjects")
    .get("/public/dashboard/privatizedObjects?year=2021")
    .check(status.is(200))

  //  val addressSearchString = http("listCountries") // getting countries by string
  //    .get(ports("ADDRESS") + s"/secured/address/country?characters=" + randomString(3))
  //    .check(status.is(200))
  //
  //  val addressSearchCode = http("listCountries") // searching address by code
  //    .get(ports("ADDRESS") + s"/secured/address/country/" + randomString(3))
  //    .check(status.is(200))
  //
  //  val login = feed(users) // data from users.csv, login
  //    .exec(http("Login")
  //      .post(ports("AUTH") + "/public/auth/login").body(StringBody(
  //      """{
  //        |
  //        |    "phoneNumber": "${log}",
  //        |
  //        |    "password": "${pass}",
  //        |
  //        |    "deviceId": "the_second_one"
  //        |}""".stripMargin)).asJson
  //      .check(status.is(200))
  ////      .check(jmesPath("data.token").saveAs("token")) //extracting token from login response
  //    )
  //  val userInfo = http("userInfo") // getting user profile info
  //
  //    .get("/secured/user/")
  //    .header("Authorization", "Bearer " + s"${token}")
  //    .check(status.is(200))
  //  val swapOutlet = feed(outlets) // data from outlets.csv, outlet
  //    .exec(http("swapOutlet") // changing user's outlet
  //    .put(ports("AUTH") + "/secured/user/change/outlet").body(StringBody(
  //    """ ${outlet}
  //      """.stripMargin)).asJson
  //    .header("Authorization", "Bearer " + s"${token}")
  //    .check(status.is(200))
  //      .check(status.is(409))
  //    )
  //
  //  val refreshToken = http("refreshToken") // getting user profile info
  //    .post(ports("AUTH") + "/public/auth/token/refresh").body(StringBody(
  //    """s{
  //      "accessToken":${token}"
  //      }""".stripMargin)).asJson
  //    .check(status.is(200))
  //    .check(status.is(401))
  //
  //  val logEvent = http("userInfo") // registration some events
  //    .post(ports("REPORT") + "/secured/log/event").body(StringBody(
  //    """{
  //          "eventType": "SELL_ATTEMPT",
  //    "eventDateTime": "2021-04-23T12:43:06.164Z",
  //    "geolocation": "test_geolocation",
  //    "addInformationField": "test_information"
  //      }""".stripMargin)).asJson
  //    .check(status.is(200))
  //    .header("Authorization", "Bearer " + s"${token}")
  //
  //  val listDocuments = http("listDocuments") // get list mandatory docs
  //    .get(ports("TELEDEALER") + "/public/fs/template_document/list")
  //    .check(status.is(200))
  //
  //  val checkCode = feed(users) // data from users.csv
  //    .exec(http("checkCode") // checking sms code
  //    .get(ports("SMS") + "/public/sms/check/code?code=" + randomNumber.nextInt(10000) + "&msisdn=${log}")
  //    .check(status.is(409))
  //    )
  //  val simAllowance = http("simAllowance") // checking a sim allowance for sale
  //
  //    .post(ports("SIM") + "/secured/simcard/saleAvailable/check").body(StringBody(
  //    s"""{
  //    "name":${randomString(6)},
  //    "surname":${randomString(6)},
  //    "documentNumber":${randomString(6)}
  //}""".stripMargin)).asJson
  //    .header("Authorization", "Bearer " + s"${token}")
  //    .check(status.is(200))
  //
  //  val logout = http("logout") // execute logout
  //    .get(ports("AUTH") + "/secured/auth/logout")
  //    .header("Authorization", "Bearer " + s"${token}")
  //    .check(status.is(200))
}


