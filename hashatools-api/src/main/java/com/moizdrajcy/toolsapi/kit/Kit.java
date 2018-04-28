package com.moizdrajcy.toolsapi.kit;

public interface Kit {

  String getName();

  String getPermission();

  void setPermission(String permission);

  long getCooldown();

  void setCooldown(long cooldown);

}
