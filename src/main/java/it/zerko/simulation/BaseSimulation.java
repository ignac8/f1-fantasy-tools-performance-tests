package it.zerko.simulation;


import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import it.zerko.config.Config;

import java.time.Duration;

public abstract class BaseSimulation extends Simulation {


  protected BaseSimulation() {
    HttpProtocolBuilder httpProtocol = HttpDsl.http;

    if (Config.shareConnections()) {
      httpProtocol.shareConnections();
    }

    ScenarioBuilder scenarioBuilder = scenarioBuilder();

    PopulationBuilder populationBuilder = scenarioBuilder.injectClosed(CoreDsl
      .constantConcurrentUsers(Config.constantUsers())
      .during(Duration.ofSeconds(Config.durationInSeconds())));

    Assertion assertion = CoreDsl.global().failedRequests().count().is(0L);

    setUp(populationBuilder)
      .protocols(httpProtocol)
      .assertions(assertion);
  }

  protected abstract ScenarioBuilder scenarioBuilder();

}
