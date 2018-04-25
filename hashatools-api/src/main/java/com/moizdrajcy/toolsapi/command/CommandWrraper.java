package com.moizdrajcy.toolsapi.command;

import java.util.List;

public abstract class CommandWrraper implements ICommand {

  final String name;
  final String description;
  final String usage;
  final String permission;
  final List<String> aliases;
  final int minArgs;
  final int maxArgs;

  public CommandWrraper(String name, String description, String usage, String permission,
      List<String> aliases, int minArgs, int maxArgs) {
    this.name = name;
    this.description = description;
    this.usage = usage;
    this.permission = permission;
    this.aliases = aliases;
    this.minArgs = minArgs;
    this.maxArgs = maxArgs;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getPermission() {
    return permission;
  }

  public List<String> getAliases() {
    return aliases;
  }

  public String getUsage() {
    return usage;
  }
}
