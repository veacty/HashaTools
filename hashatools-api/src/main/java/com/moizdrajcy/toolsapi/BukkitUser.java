package com.moizdrajcy.toolsapi;

import org.bukkit.entity.Player;

public interface BukkitUser {

  Player getPlayer();

  void sendMessage(String message);

}
