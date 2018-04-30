package com.moizdrajcy.toolsapi.config;

import java.io.File;

public final class ConfigUtil {

  private ConfigUtil() { }

  public static void create(File file, Class clazz) {
    new Config(file, clazz);
  }

}
