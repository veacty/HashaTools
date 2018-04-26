package com.moizdrajcy.tools.command;

import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.command.CommandArgs;
import com.moizdrajcy.toolsapi.command.CommandWrapper;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Collections;

public class SetHomeCommand extends CommandWrapper {

  private final HashaTools plugin;

  public SetHomeCommand(HashaTools plugin) {
    super(
        "sethome",
        "set your home",
        "/sethome ( name )",
        "hashatools.command.sethome",
        Collections.singletonList("ustawdom"),
        0
    );

    this.plugin = plugin;
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    if (args.length() < 1) {
      user.getBukkitUser().sendMessage(getUsage());
      return;
    }

    if(this.plugin.getHomeManager().add(user, args.get(0))) {
      user.getBukkitUser().sendMessage("Your home has been set");
    }
  }
}
