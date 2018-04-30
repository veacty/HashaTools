package com.moizdrajcy.tools.config;

import com.moizdrajcy.toolsapi.config.ConfigExtender;
import com.moizdrajcy.toolsapi.config.Configuration;

public class ToolsMessages extends ConfigExtender {

  public ToolsMessages(Configuration configuration) {
    super(configuration);
  }

  public static String NOT_PERMISSION = "&cI'm sorry, but you do not have permission to perform this command";
  public static String NOT_ONLINE = "&cPlayer is not online";

}
