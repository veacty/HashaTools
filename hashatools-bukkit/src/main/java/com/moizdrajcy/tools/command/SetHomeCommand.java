package com.moizdrajcy.tools.command;

import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.command.CommandHandler;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Collections;

public class SetHomeCommand extends CommandHandler {

  private final HashaTools plugin;

  public SetHomeCommand(HashaTools plugin) {
    super(
        "sethome",
        "set your home",
        "/sethome ( name )",
        "hashatools.command.sethome",
        Collections.singletonList("ustawdom"),
        1
    );

    this.plugin = plugin;
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    if(this.plugin.getHomeManager().add(user, args.get(0))) {
      user.getBukkitUser().sendMessage("Your home has been set");
    }
  }
}
