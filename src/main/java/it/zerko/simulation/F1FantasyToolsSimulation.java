package it.zerko.simulation;


import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;
import it.zerko.action.*;


public class F1FantasyToolsSimulation extends BaseSimulation {

  @Override
  protected ScenarioBuilder scenarioBuilder() {
    return CoreDsl.scenario("Well known")
      .exec(AnalystsAction.get())
      .exec(ConstructorsAction.get())
      .exec(DriversAction.get())
      .exec(NextRaceAction.get())
      .exec(PointsTypesAction.get())
      .repeat(5).on(CoreDsl.exec(RecalculateAction.get()));
  }

}
