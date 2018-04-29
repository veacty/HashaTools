package com.moizdrajcy.toolsapi;

import com.google.common.base.Preconditions;
import com.moizdrajcy.toolsapi.database.Database;
import com.moizdrajcy.toolsapi.home.HomeManager;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import com.moizdrajcy.toolsapi.user.UserManager;

public class ToolsAPI implements Tools {

  private static Tools instance;

  public static void setInstance(Tools instance) {
    ToolsAPI.instance = instance;
  }

  public static Tools get() {
    Preconditions.checkNotNull(instance);

    return instance;
  }

  @Override
  public UserManager getUserManager() {
    return instance.getUserManager();
  }

  @Override
  public Database getDatabase() {
    return instance.getDatabase();
  }

  @Override
  public HomeManager getHomeManager() {
    return instance.getHomeManager();
  }

  @Override
  public TeleportManager getTeleportManager() {
    return instance.getTeleportManager();
  }
}
