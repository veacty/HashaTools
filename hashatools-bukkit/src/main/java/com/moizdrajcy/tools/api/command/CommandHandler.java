package com.moizdrajcy.tools.api.command;

import java.util.List;

public abstract class CommandHandler implements ICommand {

  final String name;
  final String description;
  final String usage;
  final String permission;
  final List<String> aliases;
  final int minArgs;

  public CommandHandler(String name, String description, String usage, String permission,
      List<String> aliases, int minArgs) {
    this.name = name;
    this.description = description;
    this.usage = usage;
    this.permission = permission;
    this.aliases = aliases;
    this.minArgs = minArgs;
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
