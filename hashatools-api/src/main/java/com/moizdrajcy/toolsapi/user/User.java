package com.moizdrajcy.toolsapi.user;

import java.util.UUID;

public interface User {

  UUID getUUID();

  String getName();

  BukkitUser getBukkitUser();

}
