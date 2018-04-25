package com.moizdrajcy.toolsapi.database.sql;

import com.moizdrajcy.toolsapi.database.DatabaseException;
import java.sql.ResultSet;

public interface SQLDatabase {

  void update(String query) throws DatabaseException;

  ResultSet query(String query) throws DatabaseException;


}
