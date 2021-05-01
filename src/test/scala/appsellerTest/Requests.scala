package appsellerTest

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.core.json.JsonParsers


object Requests {
  val users = csv("./src/test/resources/data/users.csv").circular // users for loading
  val ports = collection.mutable.Map("ADDRESS" -> "30902", "AUTH" -> "30904") // services ports

  val listCountries = http("listCountries") // getting all countries list
    .get(ports("ADDRESS") + s"/secured/address/country?characters")
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
}


