package com.moizdrajcy.tools.teleport;

import com.google.common.collect.MapMaker;
import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.teleport.TeleportCallback;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Map;
import java.util.UUID;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TeleportManagerImpl implements TeleportManager {

  private final HashaTools plugin;
  private final Map<UUID, BukkitTask> teleportMap = new MapMaker().weakKeys().weakValues().makeMap();

  public TeleportManagerImpl(HashaTools plugin) {
    this.plugin = plugin;
  }

  @Override
  public void teleport(User user, TeleportCallback callback, long seconds) {
    if(user.getBukkitUser().getTeleportation().isPresent()) {
      callback.duringTeleportation();
      return;
    }

    callback.start();

    user.getBukkitUser().setLastLocation(user.getBukkitUser().getPlayer().getLocation());

    BukkitTask task = new BukkitRunnable() {
      @Override
      public void run() {
        remove(user);
        callback.success();
      }

    }.runTaskLater(this.plugin, seconds*20);

    user.getBukkitUser().setTeleportation(task);
    this.teleportMap.put(user.getUUID(), task);
  }

  @Override
  public void cancel(User user) {
    if (remove(user)) {
      user.getBukkitUser().sendMessage("&cTeleport canceled");
    }
  }

  @Override
  public boolean remove(User user) {
    if(user.getBukkitUser().getTeleportation().isPresent()) {
      this.teleportMap.remove(user.getUUID());
      user.getBukkitUser().setTeleportation(null);
      return true;
    }

    return false;
  }

}
