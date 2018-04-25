package com.moizdrajcy.tools.user;

import com.moizdrajcy.toolsapi.MapWithCache;
import com.moizdrajcy.toolsapi.User;
import com.moizdrajcy.toolsapi.UserManager;
import com.moizdrajcy.toolsapi.impl.ConcurrentHashMapWithCache;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class UserManagerImpl implements UserManager {

  private final MapWithCache<UUID, User> userMap = new ConcurrentHashMapWithCache<>(5, TimeUnit.MINUTES);

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
