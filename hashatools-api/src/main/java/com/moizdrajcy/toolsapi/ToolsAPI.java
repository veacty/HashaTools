package com.moizdrajcy.toolsapi;

public class ToolsAPI implements Tools {

  private static Tools instance;

  public static void setInstance(Tools instance) {
    ToolsAPI.instance = instance;
  }

  public static Tools get() {
    if(instance == null) {
      instance = new ToolsAPI();
    }

    return instance;
  }

  @Override
  public UserManager getUserManager() {
    return instance.getUserManager();
  }
}
