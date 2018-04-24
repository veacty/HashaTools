package com.moizdrajcy.tools.util;

import org.bukkit.ChatColor;

public final class Colors {

  private Colors() { }

  public static String colored(String text) {
    return ChatColor.translateAlternateColorCodes('&', text);
  }

}
