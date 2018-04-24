package com.moizdrajcy.tools.user.bukkit;

import com.moizdrajcy.tools.util.Colors;
import com.moizdrajcy.toolsapi.UserData;
import com.moizdrajcy.toolsapi.BukkitUser;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BukkitUserImpl extends UserData<UUID> implements BukkitUser {

  public BukkitUserImpl(UUID uuid) {
    super(uuid);
  }

  @Override
  public Player getPlayer() {
    return Bukkit.getPlayer(get());
  }

  @Override
  public void sendMessage(String message) {
    getPlayer().sendMessage(Colors.colored(message));
  }
}
