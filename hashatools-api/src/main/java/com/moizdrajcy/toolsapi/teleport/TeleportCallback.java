package com.moizdrajcy.toolsapi.teleport;

public interface TeleportCallback {

  void success();

  void duringTeleportation();

  void cancel();

}
