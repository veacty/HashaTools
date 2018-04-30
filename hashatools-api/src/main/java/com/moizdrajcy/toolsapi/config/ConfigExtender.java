package com.moizdrajcy.toolsapi.config;

public abstract class ConfigExtender {

  private static Configuration configuration;

  public ConfigExtender(Configuration configuration) {
    ConfigExtender.configuration = configuration;
  }

  public static void reloadConfig() {
    ConfigExtender.configuration.reload();
  }

}
