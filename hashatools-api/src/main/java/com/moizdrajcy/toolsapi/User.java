package com.moizdrajcy.toolsapi;

import java.util.UUID;

public interface User {

  UUID getUUID();

  String getName();

  BukkitUser getBukkitUser();

}
