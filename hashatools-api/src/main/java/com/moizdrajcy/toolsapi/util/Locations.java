package com.moizdrajcy.toolsapi.util;

import org.bukkit.Location;

public final class Locations {

  private Locations() { }

  public String toString(Location location) {
    return location.getWorld().getName() + ", " + location.getX() + ", " + location.getY() + ", "
        + location.getZ();
  }
}
