package com.moizdrajcy.tools.teleport;

import com.google.common.collect.MapMaker;
import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.teleport.Teleport;
import com.moizdrajcy.toolsapi.teleport.TeleportCallback;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TeleportManagerImpl implements TeleportManager {

  private final HashaTools plugin;
  private final Map<UUID, Teleport> teleportMap = new MapMaker().weakKeys().weakValues().makeMap();

  public TeleportManagerImpl(HashaTools plugin) {
    this.plugin = plugin;
  }

  @Override
  public void teleport(Player player, TeleportCallback callback) {
    if(isDuringTeleportation(player)) {
      callback.duringTeleportation();
      return;
    }

    Location before = player.getLocation();
    BukkitTask task = new BukkitRunnable() {
      @Override
      public void run() {
        callback.success();
        remove(player.getUniqueId());
      }

    }.runTaskLater(this.plugin, 10*20);

    Teleport teleport = new TeleportImpl(task, before, callback);
    this.teleportMap.put(player.getUniqueId(), teleport);
  }

  @Override
  public Optional<Teleport> getTeleport(UUID uuid) {
    return Optional.ofNullable(this.teleportMap.get(uuid));
  }

  @Override
  public Location getBefore(Player player) {
    Optional<Teleport> teleport = getTeleport(player);

    return teleport.map(Teleport::getBefore).orElse(null);
  }

  @Override
  public void remove(UUID uuid) {
    Optional<Teleport> teleport = getTeleport(uuid);
    if (teleport.isPresent()) {
      teleport.get().getTask().cancel();
      teleport.get().getCallback().cancel();

      this.teleportMap.remove(uuid);
    }
  }

  @Override
  public boolean isDuringTeleportation(UUID uuid) {
    return this.teleportMap.containsKey(uuid);

  }

}
