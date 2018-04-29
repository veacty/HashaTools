package com.moizdrajcy.toolsapi.user;

import java.util.Optional;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public interface BukkitUser {

  Player getPlayer();

  void sendMessage(String message);

  Optional<Location> getLastLocation();

  void setLastLocation(Location location);

  Optional<BukkitTask> getTeleportation();

  void setTeleportation(BukkitTask teleportation);

}
