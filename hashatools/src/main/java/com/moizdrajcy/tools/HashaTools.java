package com.moizdrajcy.tools;

import com.moizdrajcy.tools.command.TestCommand;
import com.moizdrajcy.tools.user.UserManagerImpl;
import com.moizdrajcy.tools.user.UsersListener;
import com.moizdrajcy.toolsapi.ToolsAPI;
import com.moizdrajcy.toolsapi.UserManager;
import com.moizdrajcy.toolsapi.command.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HashaTools extends JavaPlugin {

  private UserManager userManager;

  @Override
  public void onEnable() {
    ToolsAPI.setInstance(this::getUserManager);
    this.userManager = new UserManagerImpl();

    CommandManager commandManager = new CommandManager();
    commandManager.register(new TestCommand());

    Bukkit.getPluginManager().registerEvents(new UsersListener(this), this);
  }

  public UserManager getUserManager() {
    return userManager;
  }
}
