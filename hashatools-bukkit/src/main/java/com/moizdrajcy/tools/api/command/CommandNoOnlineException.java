package com.moizdrajcy.tools.api.command;

public class CommandNoOnlineException extends RuntimeException {

  public CommandNoOnlineException() {
    super();
  }

  public CommandNoOnlineException(String message) {
    super(message);
  }

}
