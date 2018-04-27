package com.moizdrajcy.toolsapi.teleport;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;

public interface Teleport {

  BukkitTask getTask();

  Location getBefore();

  TeleportCallback getCallback();

}
