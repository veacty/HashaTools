package com.moizdrajcy.tools.user.impl;

import com.moizdrajcy.toolsapi.user.BukkitUser;
import com.moizdrajcy.toolsapi.user.User;
import java.util.UUID;
import org.bukkit.scheduler.BukkitTask;

public class UserImpl implements User {

  private final UUID uuid;
  private String name;

  private BukkitUser bukkitUser;

  public UserImpl(UUID uuid) {
    this.uuid = uuid;
    this.bukkitUser = new BukkitUserImpl(uuid);
    this.name = getBukkitUser().getPlayer().getName();
  }

  @Override
  public UUID getUUID() {
    return this.uuid;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public BukkitUser getBukkitUser() {
    return this.bukkitUser;
  }

}
