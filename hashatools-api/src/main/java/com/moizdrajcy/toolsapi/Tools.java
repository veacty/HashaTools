package com.moizdrajcy.toolsapi;

import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;
import com.moizdrajcy.toolsapi.user.UserManager;

public interface Tools {

  UserManager getUserManager();

  SQLDatabase getSQLDatabase();

}

