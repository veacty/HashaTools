package com.moizdrajcy.toolsapi.command;

import com.moizdrajcy.toolsapi.command.impl.CommandArgsImpl;

public interface CommandArgs {

  default CommandArgs of(String[] args) {
    return new CommandArgsImpl(args);
  }

  int length();

  default int size() {
    return this.length();
  }

  String merge();

  String get(int index);

  String get(int index, String def);

  CommandArgs subArgs(int skip);

}
