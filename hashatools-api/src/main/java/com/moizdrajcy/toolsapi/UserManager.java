package com.moizdrajcy.toolsapi;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.entity.Player;

public interface UserManager {

  Optional<User> get(UUID uuid);

  default Optional<User> get(Player player) {
    return get(player.getUniqueId());
  }

  Optional<User> getByName(String name);

  void remove(UUID uuid);

  default void remove(Player player) {
    remove(player.getUniqueId());
  }

  default void remove(User user) {
    remove(user.getUUID());
  }

}
