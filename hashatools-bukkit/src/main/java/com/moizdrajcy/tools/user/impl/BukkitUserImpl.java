package com.moizdrajcy.tools.user.impl;

import com.moizdrajcy.toolsapi.util.Colors;
import com.moizdrajcy.toolsapi.user.BukkitUser;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BukkitUserImpl implements BukkitUser {

  private final UUID uuid;

  public BukkitUserImpl(UUID uuid) {
    this.uuid = uuid;
  }

  @Override
  public Player getPlayer() {
    return Bukkit.getPlayer(this.uuid);
  }

  @Override
  public void sendMessage(String message) {
    getPlayer().sendMessage(Colors.colored(message));
  }

}
