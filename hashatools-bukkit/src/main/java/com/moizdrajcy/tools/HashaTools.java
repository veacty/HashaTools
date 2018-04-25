package com.moizdrajcy.tools;

import com.moizdrajcy.tools.command.ExampleCommand;
import com.moizdrajcy.tools.user.UsersListener;
import com.moizdrajcy.tools.user.impl.UserManagerImpl;
import com.moizdrajcy.toolsapi.Tools;
import com.moizdrajcy.toolsapi.ToolsAPI;
import com.moizdrajcy.toolsapi.UserManager;
import com.moizdrajcy.toolsapi.command.CommandManager;
import com.moizdrajcy.toolsapi.database.Database;
import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HashaTools extends JavaPlugin implements Tools {

  private UserManager userManager;
  private SQLDatabase sqlDatabase;

  @Override
  public void onEnable() {
    ToolsAPI.setInstance(this);

    Database database = new Database("localhost", 3306, "happitorudy", "root", "");
    database.connect();
    this.sqlDatabase = database.getSQLDatabase();

    this.userManager = new UserManagerImpl();

    CommandManager commandManager = new CommandManager();
    commandManager.register(new ExampleCommand());

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

}
