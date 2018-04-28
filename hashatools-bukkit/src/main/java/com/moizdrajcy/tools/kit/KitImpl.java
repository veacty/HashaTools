package com.moizdrajcy.tools.kit;

import com.moizdrajcy.toolsapi.kit.Kit;

public class KitImpl implements Kit {

  private final String name;
  private String permission;
  private long cooldown;

  public KitImpl(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getPermission() {
    return this.permission;
  }

  @Override
  public void setPermission(String permission) {
    this.permission = permission;
  }

  @Override
  public long getCooldown() {
    return this.cooldown;
  }

  @Override
  public void setCooldown(long cooldown) {
    this.cooldown = cooldown;
  }
}
