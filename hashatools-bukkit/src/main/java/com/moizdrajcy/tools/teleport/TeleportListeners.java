package com.moizdrajcy.tools.teleport;

import com.moizdrajcy.toolsapi.Tools;
import com.moizdrajcy.toolsapi.user.User;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TeleportListeners implements Listener {

  private final Tools plugin;

  public TeleportListeners(Tools plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();
    Location now = player.getLocation();
    User user = this.plugin.getUserManager().get(player).get();

    if(user.getBukkitUser().getTeleportation().isPresent()) {
      Location before = user.getBukkitUser().getLastLocation().get();

      if(now.getBlockX() != before.getBlockX()
              || now.getBlockZ() != before.getBlockZ()
              || now.getY() != before.getY()) {
        this.plugin.getTeleportManager().cancel(user); //TODO: fix cancelling tasks
      }
    }
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    this.plugin.getTeleportManager().cancel(this.plugin.getUserManager().get(event.getPlayer()).get());
  }

}
