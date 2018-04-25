package com.moizdrajcy.tools.command;

import com.moizdrajcy.toolsapi.User;
import com.moizdrajcy.toolsapi.command.CommandArgs;
import com.moizdrajcy.toolsapi.command.CommandWrraper;
import java.util.Arrays;
import org.bukkit.command.CommandSender;

public class TestCommand extends CommandWrraper {

  public TestCommand() {
    super(
        "test",
        "",
        "/test <arg1>",
        "command.command",
        Arrays.asList("testt", "testtt"),
        1,
        3);
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    user.getBukkitUser().sendMessage("&7siema");
  }

}
