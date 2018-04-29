package com.moizdrajcy.toolsapi.command;

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

      } catch (IllegalAccessException | NoSuchFieldException e) {
        e.printStackTrace();
      }
    }
  }

  public void register(CommandHandler commandHandler) {
    Command command = new Command(commandHandler.name, commandHandler.description,
        commandHandler.usage,
        commandHandler.aliases) {
      @Override
      public boolean execute(CommandSender sender, String s, String[] strings) {
        CommandArgs args = new CommandArgs(strings);

        if (!sender.hasPermission(commandHandler.permission)) {
          sendMessage(sender, "&cI'm sorry, but you do not have permission to perform this command");
          return true;
        }

        if (args.size() < commandHandler.minArgs) {
          sendMessage(sender, commandHandler.usage);
          return true;
        }

        commandHandler.execute(sender, args);
        return true;
      }
    };

    this.commandMap.register("", command);

  }

  public void register(CommandHandler... commands) {
    Arrays.stream(commands).forEach(this::register);
  }

  private void sendMessage(CommandSender sender, String message) {
    sender.sendMessage(Colors.colored(message));
  }

}
