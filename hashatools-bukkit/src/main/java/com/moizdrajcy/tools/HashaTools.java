package com.moizdrajcy.tools;

import com.moizdrajcy.tools.command.HomeCommand;
import com.moizdrajcy.tools.command.SetHomeCommand;
import com.moizdrajcy.tools.command.example.ExampleCommand;
import com.moizdrajcy.tools.home.HomeManagerImpl;
import com.moizdrajcy.tools.teleport.TeleportListeners;
import com.moizdrajcy.tools.teleport.TeleportManagerImpl;
import com.moizdrajcy.tools.user.UsersListeners;
import com.moizdrajcy.tools.user.impl.UserManagerImpl;
import com.moizdrajcy.toolsapi.Tools;
import com.moizdrajcy.toolsapi.ToolsAPI;
import com.moizdrajcy.toolsapi.command.CommandManager;
import com.moizdrajcy.toolsapi.database.Database;
import com.moizdrajcy.toolsapi.database.DatabaseBuilder;
import com.moizdrajcy.toolsapi.database.DatabaseSettings;
import com.moizdrajcy.toolsapi.home.HomeManager;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import com.moizdrajcy.toolsapi.user.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HashaTools extends JavaPlugin implements Tools {

  private UserManager userManager;
  private HomeManager homeManager;
  private TeleportManager teleportManager;
  private Database database;

  @Override
  public void onEnable() {
    ToolsAPI.setInstance(this);

    DatabaseSettings settings = new DatabaseSettings();
    settings.setDatabase("mordziaty");

    this.database = DatabaseBuilder.create()
        .setup(settings)
        .connect()
        .createTables()
        .build();

    this.userManager = new UserManagerImpl();
    this.homeManager = new HomeManagerImpl();
    this.teleportManager = new TeleportManagerImpl(this);

    CommandManager commandManager = new CommandManager();
    commandManager.register(new ExampleCommand());
    commandManager.register(new SetHomeCommand(this));
    commandManager.register(new HomeCommand(this));

    registerListeners(this,
        new UsersListeners(this),
        new TeleportListeners(this)
    );

  }

  @Override
  public UserManager getUserManager() {
    return this.userManager;
  }

  @Override
  public Database getDatabase() {
    return this.database;
  }

  @Override
  public HomeManager getHomeManager() {
    return this.homeManager;
  }

  @Override
  public TeleportManager getTeleportManager() {
    return this.teleportManager;
  }

}