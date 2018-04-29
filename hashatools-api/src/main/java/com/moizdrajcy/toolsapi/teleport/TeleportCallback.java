package com.moizdrajcy.toolsapi.teleport;

public interface TeleportCallback {

  void start();

  void success();

  void duringTeleportation();

  void cancel();

}
