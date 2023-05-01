package it.zerko.config;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Config {

  public String apiUrl() {
    return "https://f1fantasytoolsapi-szumjzgxfa-ew.a.run.app";
  }

  public int constantUsers() {
    return 10;
  }

  public int durationInSeconds() {
    return 60;
  }

}
