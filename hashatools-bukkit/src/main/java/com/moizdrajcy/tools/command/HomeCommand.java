package com.moizdrajcy.tools.command;

import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.command.CommandArgs;
import com.moizdrajcy.toolsapi.command.CommandWrapper;
import com.moizdrajcy.toolsapi.home.Home;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Collections;
import java.util.Optional;

public class HomeCommand extends CommandWrapper {

  private final HashaTools plugin;

  public HomeCommand(HashaTools plugin) {
    super(
        "home",
        "example command",
        "/home ( name of home )",
        "hashatools.command.home",
        Collections.singletonList("dom"),
        0
    );

    this.plugin = plugin;
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    if(args.length() < 1) {
      user.getBukkitUser().sendMessage("list of homes");
      return;
    }

    Optional<Home> home = this.plugin.getHomeManager().getHome(user, args.get(0));

    if(!home.isPresent()) {
      user.getBukkitUser().sendMessage("Home doesn't exist");
      return;
    }

    //TODO teleport system

    user.getBukkitUser().getPlayer().teleport(home.get().getLocation());
    user.getBukkitUser().sendMessage("telported to home");
  }

}
