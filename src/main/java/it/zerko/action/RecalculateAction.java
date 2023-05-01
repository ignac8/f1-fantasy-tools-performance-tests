package it.zerko.action;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import it.zerko.config.Config;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class RecalculateAction {

  private final Gson gson = new Gson();

  public HttpRequestActionBuilder get() {
    return HttpDsl.http("Recalculate")
      .post("%s/team-calculator/recalculate".formatted(Config.apiUrl()))
      .header("content-type", "application/json")
      .body(CoreDsl.StringBody(gson.toJson(new Body(
        90,
        100,
        List.of(),
        new Object(),
        List.of(),
        List.of(),
        true,
        false,
        false,
        "weighted_average_season_score",
        "current_price",
        0,
        "points",
        false,
        2))));
  }

  record Body(
    @SerializedName("alpha_value") int alphaValue,
    @SerializedName("current_budget") int currentBudget,
    @SerializedName("current_team") List<Object> currentTeam,
    @SerializedName("custom_points") Object customPoints,
    @SerializedName("exclude") List<Object> exclude,
    @SerializedName("include") List<Object> include,
    @SerializedName("include_dnf_scores") boolean includeDnfScores,
    @SerializedName("mega_driver_option") boolean megaDriverOption,
    @SerializedName("no_penalties") boolean noPenalties,
    @SerializedName("points_type") String pointsType,
    @SerializedName("prices_type") String pricesType,
    @SerializedName("remaining_budget") int remainingBudget,
    @SerializedName("sort_by") String sortBy,
    @SerializedName("sprint_race_option") boolean sprintRaceOption,
    @SerializedName("swaps_left") int swapsLeft) {
  }

}
