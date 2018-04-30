package com.moizdrajcy.tools.command;

import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.tools.api.command.CommandArgs;
import com.moizdrajcy.tools.api.command.CommandHandler;
import com.moizdrajcy.tools.config.ToolsMessages;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Arrays;
import java.util.Optional;

public class MsgCommand extends CommandHandler {

  private final HashaTools plugin;

  public MsgCommand(HashaTools plugin) {
    super(
        "msg",
        "",
        "/msg ( name of player ) ( message )",
        "hashatools.command.msg",
        Arrays.asList("message", "tell"),
        2
    );

    this.plugin = plugin;
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    Optional<User> recipient = this.plugin.getUserManager().getByName(args.get(0));

    if(!recipient.isPresent()) {
      user.getBukkitUser().sendMessage(ToolsMessages.NOT_ONLINE);
      return;
    }

    this.plugin.getMsgManager().add(user.getUUID(), recipient.get().getUUID());

  }

}
