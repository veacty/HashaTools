package com.moizdrajcy.tools.command;

import com.moizdrajcy.toolsapi.User;
import com.moizdrajcy.toolsapi.command.CommandArgs;
import com.moizdrajcy.toolsapi.command.CommandWrraper;
import java.util.Arrays;
import org.bukkit.command.CommandSender;

public class ExampleCommand extends CommandWrraper {

  public ExampleCommand() {
    super(
        "example",
        "example command",
        "/example <arg1> <arg2> <arg3>",
        "hashatools.command.example",
        Arrays.asList("exampl", "examp"),
        1,
        3);
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    user.getBukkitUser().sendMessage("&7siema");
  }

}
