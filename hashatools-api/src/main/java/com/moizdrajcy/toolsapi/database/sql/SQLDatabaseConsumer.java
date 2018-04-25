package com.moizdrajcy.toolsapi.database.sql;

import com.moizdrajcy.toolsapi.database.DatabaseException;
import java.sql.PreparedStatement;

@FunctionalInterface
public interface SQLDatabaseConsumer {

  void accept(PreparedStatement statement) throws DatabaseException;

}
