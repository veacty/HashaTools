package com.moizdrajcy.tools.command;

import com.moizdrajcy.tools.HashaTools;
import com.moizdrajcy.toolsapi.command.CommandHandler;
import com.moizdrajcy.toolsapi.home.Home;
import com.moizdrajcy.toolsapi.teleport.TeleportCallback;
import com.moizdrajcy.toolsapi.user.User;
import java.util.Collections;
import java.util.Optional;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerTeleportEvent;

public class HomeCommand extends CommandHandler {

  private final HashaTools plugin;

  public HomeCommand(HashaTools plugin) {
    super(
        "home",
        "example command",
        "/home ( name of home )",
        "hashatools.command.home",
        Collections.singletonList("dom"),
        1
    );

    this.plugin = plugin;
  }

  @Override
  public void executeUser(User user, CommandArgs args) {
    Optional<Home> home = this.plugin.getHomeManager().getHome(user, args.get(0));

    if (!home.isPresent()) {
      user.getBukkitUser().sendMessage("Home doesn't exist");
      return;
    }

    PlayerTeleportEvent teleportEvent = new PlayerTeleportEvent(user.getBukkitUser().getPlayer(),
        user.getBukkitUser().getPlayer().getLocation(),
        home.get().getLocation());
    Bukkit.getPluginManager().callEvent(teleportEvent);

    if(teleportEvent.isCancelled()) {
      return;
    }

    this.plugin.getTeleportManager().teleport(user,
        new TeleportCallback() {
          @Override
          public void start() {
            user.getBukkitUser().sendMessage("...");
          }

          @Override
          public void success() {
            user.getBukkitUser().getPlayer().teleport(home.get().getLocation());
            user.getBukkitUser().sendMessage("&aTeleportion success");
          }

          @Override
          public void duringTeleportation() {
            user.getBukkitUser().sendMessage("&cYou are already teleporting");
          }

          @Override
          public void cancel() {
            user.getBukkitUser().sendMessage("&cTeleportion has been canceled");
          }
        }, 10);
  }

}
