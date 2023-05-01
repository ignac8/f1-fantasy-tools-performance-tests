package it.zerko.action;

import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import it.zerko.config.Config;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PointsTypesAction {

  public HttpRequestActionBuilder get() {
    return HttpDsl.http("Points-types")
      .get("%s/team-calculator/points-types".formatted(Config.apiUrl()))
      .header("content-type", "application/json");
  }

}
