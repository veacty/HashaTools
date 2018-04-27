package com.moizdrajcy.tools.user;

import com.google.common.base.Preconditions;
import com.moizdrajcy.tools.HashaTools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UsersListeners implements Listener {

  private final HashaTools plugin;

  public UsersListeners(HashaTools plugin) {
    Preconditions.checkNotNull(plugin);

    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    this.plugin.getUserManager().get(event.getPlayer());

  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    this.plugin.getUserManager().remove(event.getPlayer());

  }

}
