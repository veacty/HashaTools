package com.moizdrajcy.tools.teleport;

import com.moizdrajcy.toolsapi.teleport.Teleport;
import com.moizdrajcy.toolsapi.teleport.TeleportCallback;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitTask;

public class TeleportImpl implements Teleport {

  private final BukkitTask task;
  private final Location before;
  private final TeleportCallback callback;

  public TeleportImpl(BukkitTask task, Location before,
      TeleportCallback callback) {
    this.task = task;
    this.before = before;
    this.callback = callback;
  }

  @Override
  public BukkitTask getTask() {
    return this.task;
  }

  @Override
  public Location getBefore() {
    return this.before;
  }

  @Override
  public TeleportCallback getCallback() {
    return this.callback;
  }
}
