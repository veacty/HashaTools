package com.moizdrajcy.toolsapi.home;

import com.moizdrajcy.toolsapi.user.User;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface HomeManager {

  Optional<Home> getHome(UUID uuid, String name);

  default Optional<Home> getHome(User user, String name) {
    return getHome(user.getUUID(), name);
  }

  boolean add(UUID uuid, String name, Location location);

  default boolean add(Player player, String name) {
    return add(player.getUniqueId(), name, player.getLocation());
  }

  default boolean add(User user, String name) {
    return add(user.getUUID(), name, user.getBukkitUser().getPlayer().getLocation());
  }

  default boolean add(UUID uuid, Home home) {
    return add(uuid, home.getName(), home.getLocation());
  }

  default boolean add(Player player, Home home) {
    return add(player.getUniqueId(), home.getName(), home.getLocation());
  }

  default boolean add(User user, Home home) {
    return add(user.getUUID(), home.getName(), home.getLocation());
  }

  boolean remove(UUID uuid, String name);

  default boolean remove(Player player, String name) {
    return remove(player.getUniqueId(), name);
  }

  default boolean remove(User user, String name) {
    return remove(user.getUUID(), name);
  }

  Collection<Home> getHomes(UUID uuid);

  default Collection<Home> getHomes(Player player) {
    return getHomes(player.getUniqueId());
  }

  default Collection<Home> getHomes(User user) {
    return getHomes(user.getUUID());
  }

}
