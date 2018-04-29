package com.moizdrajcy.toolsapi;

import com.moizdrajcy.toolsapi.database.Database;
import com.moizdrajcy.toolsapi.home.HomeManager;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import com.moizdrajcy.toolsapi.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public interface Tools {

  UserManager getUserManager();

  Database getDatabase();

  HomeManager getHomeManager();

  TeleportManager getTeleportManager();

  default void registerListeners(Plugin plugin, Listener... listeners) {
    for(Listener listener : listeners) {
      Bukkit.getPluginManager().registerEvents(listener, plugin);
    }
  }

}

