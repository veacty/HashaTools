package com.moizdrajcy.tools;

import com.moizdrajcy.tools.command.HomeCommand;
import com.moizdrajcy.tools.command.SetHomeCommand;
import com.moizdrajcy.tools.command.example.ExampleCommand;
import com.moizdrajcy.tools.home.HomeManagerImpl;
import com.moizdrajcy.tools.user.UsersListener;
import com.moizdrajcy.tools.user.impl.UserManagerImpl;
import com.moizdrajcy.toolsapi.Tools;
import com.moizdrajcy.toolsapi.ToolsAPI;
import com.moizdrajcy.toolsapi.home.HomeManager;
import com.moizdrajcy.toolsapi.user.UserManager;
import com.moizdrajcy.toolsapi.command.CommandManager;
import com.moizdrajcy.toolsapi.database.Database;
import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HashaTools extends JavaPlugin implements Tools {

  private SQLDatabase sqlDatabase;
  private UserManager userManager;
  private HomeManager homeManager;

  @Override
  public void onEnable() {
    ToolsAPI.setInstance(this);

    Database database = new Database("localhost", 3306, "happitorudy", "root", "");
    //database.connect();
    //this.sqlDatabase = database.getSQLDatabase();

    this.userManager = new UserManagerImpl();
    this.homeManager = new HomeManagerImpl();

    CommandManager commandManager = new CommandManager();
    commandManager.register(new ExampleCommand());
    commandManager.register(new SetHomeCommand(this));
    commandManager.register(new HomeCommand(this));

    Bukkit.getPluginManager().registerEvents(new UsersListener(this), this);

  }

  @Override
  public UserManager getUserManager() {
    return this.userManager;
  }

  @Override
  public SQLDatabase getSQLDatabase() {
    return this.sqlDatabase;
  }

  @Override
  public HomeManager getHomeManager() {
    return this.homeManager;
  }

}
