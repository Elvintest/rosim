//package computerdatabase
package Rosim

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import Requests._
import io.gatling.core.structure.ScenarioBuilder

import scala.language.postfixOps
import scala.annotation.tailrec


class BasicSimulation extends Simulation {
  val httpProtocol = http
    .baseUrl("http://mp-dev-front.apps.ocp.dev.rosim.tech") // корень для всех относительных URL
    .acceptHeader(
      "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
    ) // Вот общие заголовки
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader(
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
    )
//  val records: Seq[Map[String, Any]] = csv("./src/test/resources/data/users.csv").readRecords
  val scn =
    scenario(f"load test") //
      .exec(facilityRentalList)

  setUp(scn.inject(constantUsersPerSec(1) during(1 seconds)).protocols(httpProtocol))

}
