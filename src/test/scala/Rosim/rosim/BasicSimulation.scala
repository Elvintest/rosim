//package computerdatabase
package Rosim

import Rosim.Requests._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps


class BasicSimulation extends Simulation {
  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://mp-dev-front.apps.ocp.dev.rosim.tech") // корень для всех относительных URL
    .acceptHeader(
      "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
    ) // Вот общие заголовки
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader(
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
    )


  val scn: ScenarioBuilder =
    scenario(f"load test") //
      .exec(facilityRentalList)

  setUp(scn.inject(constantUsersPerSec(1) during(1 seconds)).protocols(httpProtocol))

}
