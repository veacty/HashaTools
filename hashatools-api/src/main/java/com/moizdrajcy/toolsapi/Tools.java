package com.moizdrajcy.toolsapi;

import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;

public interface Tools {

  UserManager getUserManager();

  SQLDatabase getSQLDatabase();

}

