package com.moizdrajcy.toolsapi.teleport;

import com.moizdrajcy.toolsapi.user.User;

public interface TeleportManager {

  void teleport(User user, TeleportCallback callback, long seconds);

  void cancel(User user);

  boolean remove(User user);
}
