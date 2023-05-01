package it.zerko.action;


import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import it.zerko.config.Config;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AnalystsAction {


  public HttpRequestActionBuilder get() {
    return HttpDsl.http("Analysts")
      .get("%s/team-calculator/analysts".formatted(Config.apiUrl()))
      .header("content-type", "application/json");
  }

}
