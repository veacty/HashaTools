package com.moizdrajcy.tools.home;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.moizdrajcy.toolsapi.home.Home;
import com.moizdrajcy.toolsapi.home.HomeManager;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;

public class HomeManagerImpl implements HomeManager {

  private final Multimap<UUID, Home> homeMap = HashMultimap.create();

  @Override
  public Optional<Home> getHome(UUID uuid, String name) {
    for(Home home : getHomes(uuid)) {
      if(home.getName().equalsIgnoreCase(name)) {
        return Optional.of(home);
      }
    }

    return Optional.empty();
  }


  @Override
  public boolean add(UUID uuid, String name, Location location) {
    Optional<Home> home = getHome(uuid, name);

    if(!home.isPresent()) {
      home = Optional.of(new HomeImpl(name, location));
      this.homeMap.put(uuid, home.get());

      return true;
    }

    return false;
  }

  @Override
  public boolean remove(UUID uuid, String name) {
    Optional<Home> home = getHome(uuid, name);

    if(home.isPresent()) {
      this.homeMap.remove(uuid, home.get());

      return true;
    }

    return false;
  }

  @Override
  public Collection<Home> getHomes(UUID uuid) {
    return this.homeMap.get(uuid);
  }

}
