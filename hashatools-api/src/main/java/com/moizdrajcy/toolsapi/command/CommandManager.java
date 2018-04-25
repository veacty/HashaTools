package com.moizdrajcy.toolsapi.command;

import com.moizdrajcy.toolsapi.command.impl.CommandArgsImpl;
import com.moizdrajcy.toolsapi.util.Colors;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

public class CommandManager {

  private CommandMap commandMap;

  public CommandManager() {
    if (this.commandMap == null) {
      try {
        Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        field.setAccessible(true);
        this.commandMap = ((CommandMap) field.get(Bukkit.getServer()));
        field.setAccessible(false);

      }
      catch (IllegalAccessException | NoSuchFieldException e) {
        e.printStackTrace();
      }
    }
  }

  public void register(CommandWrraper commandWrraper) {
    Command command = new Command(commandWrraper.name, commandWrraper.description, commandWrraper.usage,
        commandWrraper.aliases) {
      @Override
      public boolean execute(CommandSender sender, String s, String[] strings) {
        CommandArgs args = new CommandArgsImpl(strings);

        if (!sender.hasPermission(commandWrraper.permission)) {
          sendMessage(sender,":(");
          return true;
        }

        if ((args.size() < commandWrraper.minArgs) || (args.size() > commandWrraper.maxArgs)) {
          sendMessage(sender, commandWrraper.usage);
          return true;
        }

        commandWrraper.execute(sender, args);
        return true;
      }
    };

    this.commandMap.register("", command);
  }

  public void register(CommandWrraper... commands) {
    Arrays.stream(commands).forEach(this::register);
  }

  private void sendMessage(CommandSender sender, String message) {
    sender.sendMessage(Colors.colored(message));
  }

}
