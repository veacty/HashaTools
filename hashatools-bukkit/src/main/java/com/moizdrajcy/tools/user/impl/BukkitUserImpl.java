package com.moizdrajcy.tools.user.impl;

import com.moizdrajcy.toolsapi.util.Colors;
import com.moizdrajcy.toolsapi.user.BukkitUser;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class BukkitUserImpl implements BukkitUser {

  private final UUID uuid;

  private Location lastLocation;
  private BukkitTask teleportation;

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

  @Override
  public Optional<Location> getLastLocation() {
    return Optional.ofNullable(this.lastLocation);
  }

  @Override
  public void setLastLocation(Location location) {
    this.lastLocation = location;
  }

  @Override
  public Optional<BukkitTask> getTeleportation() {
    return Optional.ofNullable(this.teleportation);
  }

  @Override
  public void setTeleportation(BukkitTask teleportation) {
    this.teleportation = teleportation;
  }

}
