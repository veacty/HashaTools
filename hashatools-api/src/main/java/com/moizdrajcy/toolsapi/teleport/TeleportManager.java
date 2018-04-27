package com.moizdrajcy.toolsapi.teleport;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface TeleportManager {

  void teleport(Player player, TeleportCallback callback);

  Optional<Teleport> getTeleport(UUID uuid);

  default Optional<Teleport> getTeleport(Player player) {
    return getTeleport(player.getUniqueId());
  }

  Location getBefore(Player player);

  void remove(UUID uuid);

  default void remove(Player player) {
    remove(player.getUniqueId());
  }

  boolean isDuringTeleportation(UUID uuid);

  default boolean isDuringTeleportation(Player player) {
    return isDuringTeleportation(player.getUniqueId());
  }

}
