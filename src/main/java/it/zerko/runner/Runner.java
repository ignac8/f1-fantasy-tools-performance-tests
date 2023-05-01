package it.zerko.runner;

import io.gatling.app.Gatling;
import io.gatling.core.config.GatlingPropertiesBuilder;

import java.nio.file.Paths;

public class Runner {

  public static void main(String[] args) {
    Gatling.fromMap(new GatlingPropertiesBuilder()
      .resourcesDirectory(Paths.get("src").resolve("main").resolve("resources").toString())
      .resultsDirectory(Paths.get("target").resolve("gatling").toString())
      .binariesDirectory(Paths.get("target").resolve("classes").toString())
      .build());
  }
}
