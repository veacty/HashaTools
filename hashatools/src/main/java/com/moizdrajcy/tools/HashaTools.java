package com.moizdrajcy.tools;

import com.moizdrajcy.tools.user.UserManagerImpl;
import com.moizdrajcy.toolsapi.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HashaTools extends JavaPlugin {

  private UserManager userManager;

  @Override
  public void onEnable() {
    this.userManager = new UserManagerImpl();
  }

  public UserManager getUserManager() {
    return userManager;
  }
}
