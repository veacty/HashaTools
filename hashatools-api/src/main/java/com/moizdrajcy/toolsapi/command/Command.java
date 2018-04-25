package com.moizdrajcy.toolsapi.command;

import com.moizdrajcy.toolsapi.User;
import org.bukkit.command.CommandSender;

public interface Command {

  default void execute(CommandSender sender, CommandArgs args) {
    if(sender instanceof User) {
      executeUser((User) sender, args);
    }
  }

  default void executeUser(User user, CommandArgs args) {
    throw new UnsupportedOperationException("Command has to implement execute");
  }

}
