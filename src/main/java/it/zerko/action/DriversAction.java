package it.zerko.action;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import it.zerko.config.Config;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DriversAction {

  private final Gson gson = new Gson();

  public HttpRequestActionBuilder get() {
    return HttpDsl.http("Drivers")
      .post("%s/team-calculator/drivers".formatted(Config.apiUrl()))
      .header("content-type", "application/json")
      .body(CoreDsl.StringBody(gson.toJson(new Body(false, 90, true))));
  }

  private record Body
    (@SerializedName("sprint_race_option") boolean sprintRaceOption,
     @SerializedName("alpha_value") int alphaValue,
     @SerializedName("include_dnf_scores") boolean includeDnfScores) {
  }

}
