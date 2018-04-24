package com.moizdrajcy.tools.api;

import com.moizdrajcy.tools.user.UserManagerImpl;
import com.moizdrajcy.toolsapi.Tools;
import com.moizdrajcy.toolsapi.UserManager;
import org.jetbrains.annotations.Nullable;

@Nullable
public class ToolsAPI implements Tools {

  private static Tools instance;

  private UserManager userManager;

  public static Tools get() {
    if(instance == null) {
      instance = new ToolsAPI();
    }

    return instance;
  }

  @Override
  public UserManager getUserManager() {
    if(userManager == null) {
      userManager = new UserManagerImpl();
    }

    return this.userManager;
  }
}
