package com.moizdrajcy.tools.command.example;

import com.moizdrajcy.toolsapi.user.User;
import com.moizdrajcy.toolsapi.command.CommandArgs;
import com.moizdrajcy.toolsapi.command.CommandWrapper;
import java.util.Arrays;

public class ExampleCommand extends CommandWrapper {

  public ExampleCommand() {
    super(
        "example",
        "example command",
        "/example <arg1> <arg2> <arg3>",
        "hashatools.command.example",
        Arrays.asList("exampl", "examp"),
        1
    );
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    user.getBukkitUser().sendMessage("&7siema");
  }

}
