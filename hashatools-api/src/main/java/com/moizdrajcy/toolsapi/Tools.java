package com.moizdrajcy.toolsapi;

import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;
import com.moizdrajcy.toolsapi.home.HomeManager;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import com.moizdrajcy.toolsapi.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public interface Tools {

  UserManager getUserManager();

  SQLDatabase getSQLDatabase();

  HomeManager getHomeManager();

  TeleportManager getTeleportManager();

  default void registerListeners(Plugin plugin, Listener... listeners) {
    for(Listener listener : listeners) {
      Bukkit.getPluginManager().registerEvents(listener, plugin);
    }
  }

}

