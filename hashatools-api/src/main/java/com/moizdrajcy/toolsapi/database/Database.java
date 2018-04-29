package com.moizdrajcy.toolsapi.database;

import java.sql.ResultSet;

public interface Database {

  void update(String query) throws DatabaseException;

  ResultSet query(String query) throws DatabaseException;

}
