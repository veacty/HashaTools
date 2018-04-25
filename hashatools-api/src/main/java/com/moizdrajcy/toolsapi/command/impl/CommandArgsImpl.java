package com.moizdrajcy.toolsapi.command.impl;

import com.google.common.base.Joiner;
import com.moizdrajcy.toolsapi.command.CommandArgs;
import java.util.Arrays;

public class CommandArgsImpl implements CommandArgs {

  private static final Joiner joiner = Joiner.on(' ');
  private String[] args;

  public CommandArgsImpl(String[] args) {
    this.args = args;
  }

  @Override
  public int length() {
    return this.args.length;
  }

  @Override
  public String merge() {
    return CommandArgsImpl.joiner.join(this.args);
  }

  @Override
  public String get(int index) {
    return this.args[index];
  }

  @Override
  public String get(int index, String def) {
    return (index < this.args.length) ? this.args[index] : def;
  }

  @Override
  public CommandArgs subArgs(int skip) {
    return new CommandArgsImpl(Arrays.copyOfRange(this.args, Math.min(skip, this.args.length), this.args.length));
  }
}
