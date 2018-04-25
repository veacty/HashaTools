package com.moizdrajcy.tools.user.impl;

import com.google.common.collect.Maps;
import com.moizdrajcy.toolsapi.user.User;
import com.moizdrajcy.toolsapi.user.UserManager;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserManagerImpl implements UserManager {

  private final Map<UUID, User> userMap = Maps.newConcurrentMap();

  @Override
  public Optional<User> get(UUID uuid) {
    User user = this.userMap.get(uuid);

    if(user == null) {
      user = new UserImpl(uuid);
      this.userMap.put(uuid, user);
    }

    return Optional.of(user);
  }

  @Override
  public Optional<User> getByName(String name) {
    return this.userMap
        .values()
        .stream()
        .filter(user -> user.getName().equalsIgnoreCase(name))
        .findFirst();
  }

  @Override
  public void remove(UUID uuid) {
    this.userMap.remove(uuid);
  }
}
