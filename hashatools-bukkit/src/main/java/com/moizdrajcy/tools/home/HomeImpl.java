package com.moizdrajcy.tools.home;

import com.moizdrajcy.toolsapi.home.Home;
import org.bukkit.Location;

public class HomeImpl implements Home {

  private final String name;
  private final Location location;

  public HomeImpl(String name, Location location) {
    this.name = name;
    this.location = location;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Location getLocation() {
    return this.location;
  }
}
