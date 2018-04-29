package com.moizdrajcy.toolsapi.command;

import com.google.common.base.Joiner;
import java.util.Arrays;

public class CommandArgs {

  private static final Joiner joiner = Joiner.on(' ');
  private String[] args;

  public CommandArgs(String[] args) {
    this.args = args;
  }

  public int length() {
    return this.args.length;
  }

  public int size() {
    return this.length();
  }

  public String merge() {
    return CommandArgs.joiner.join(this.args);
  }

  public String get(int index) {
    return this.args[index];
  }

  public String get(int index, String def) {
    return (index < this.args.length) ? this.args[index] : def;
  }

}
