package com.moizdrajcy.tools.teleport;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.teleport.Teleport;
import com.moizdrajcy.toolsapi.teleport.TeleportCallback;
import com.moizdrajcy.toolsapi.teleport.TeleportManager;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TeleportManagerImpl implements TeleportManager {

  private final HashaTools plugin;
  private final Cache<UUID, Teleport> teleportCache = CacheBuilder.newBuilder().expireAfterWrite(12, TimeUnit.SECONDS).build();

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
      }

    }.runTaskLater(this.plugin, 10*20);

    Teleport teleport = new TeleportImpl(task, before, callback);
    this.teleportCache.put(player.getUniqueId(), teleport);
  }

  @Override
  public Optional<Teleport> getTeleport(UUID uuid) {
    return Optional.ofNullable(this.teleportCache.getIfPresent(uuid));
  }

  @Override
  public Location getBefore(Player player) {
    Optional<Teleport> teleport = getTeleport(player);

    return teleport.map(Teleport::getBefore).orElse(null);

  }

  @Override
  public void remove(UUID uuid) {
    Teleport teleport = this.teleportCache.getIfPresent(uuid);
    if (teleport != null) {
      teleport.getTask().cancel();
      teleport.getCallback().cancel();

      this.teleportCache.invalidate(uuid);
    }
  }

  @Override
  public boolean isDuringTeleportation(UUID uuid) {
    return this.teleportCache.asMap().containsKey(uuid);

  }

}
