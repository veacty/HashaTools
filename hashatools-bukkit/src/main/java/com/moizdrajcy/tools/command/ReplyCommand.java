package com.moizdrajcy.tools.command;

import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.tools.api.command.CommandArgs;
import com.moizdrajcy.tools.api.command.CommandHandler;
import com.moizdrajcy.tools.config.ToolsMessages;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Collections;

public class ReplyCommand extends CommandHandler {

  private final HashaTools plugin;

  public ReplyCommand(HashaTools plugin) {
    super(
        "reply",
        "",
        "/reply ( message )",
        "hashatools.command.reply",
        Collections.singletonList("r"),
        1
    );

    this.plugin = plugin;
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    User recipient = this.plugin.getMsgManager().getRecipient(user);


    if (recipient == null) {
      user.getBukkitUser().sendMessage(ToolsMessages.NOT_ONLINE);
      return;
    }

    this.plugin.getMsgManager().add(user.getUUID(), recipient.getUUID());

  }
}
