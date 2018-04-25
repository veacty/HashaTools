package com.moizdrajcy.toolsapi.database;

import java.sql.SQLException;

public class DatabaseException extends RuntimeException {

  private static final long serialVersionUID = 666;

  public DatabaseException() {
    super();
  }

  public DatabaseException(SQLException exception) {
    super(exception);
  }

}
