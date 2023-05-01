package it.zerko.action;

import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import it.zerko.config.Config;
import lombok.experimental.UtilityClass;

@UtilityClass
public class NextRaceAction {

  public HttpRequestActionBuilder get() {
    return HttpDsl.http("Next race")
      .get("%s/team-calculator/next-race".formatted(Config.apiUrl()))
      .header("content-type", "application/json");
  }

}
