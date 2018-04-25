package com.moizdrajcy.toolsapi.command;

import com.moizdrajcy.toolsapi.ToolsAPI;
import com.moizdrajcy.toolsapi.User;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface ICommand {

  default void execute(CommandSender sender, CommandArgs args) {
    if(sender instanceof Player) {
      Player player = (Player) sender;
      executeUser(ToolsAPI.get().getUserManager().get(player).get(), args);
      return;
    }

    executeSender(sender, args);
  }

  default void executeUser(User user, CommandArgs args) {
    throw new UnsupportedOperationException("ICommand has to implement execute");
  }

  default void executeSender(CommandSender sender, CommandArgs args) {
    throw new UnsupportedOperationException("ICommand has to implement execute");
  }

}
