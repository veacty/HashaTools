package com.moizdrajcy.toolsapi.database;

import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;
import com.moizdrajcy.toolsapi.database.sql.impl.SQLDatabaseImpl;
import com.zaxxer.hikari.HikariConfig;

public class Database {

  private String url;
  private String user;
  private String password;

  private SQLDatabase sqlDatabase;

  public Database(String host, int port, String database, String user, String password) {
    this.url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    this.user = user;
    this.password = password;
  }

  private HikariConfig config() {
    HikariConfig config = new HikariConfig();

    config.setJdbcUrl(url + "?autoReconnect=true");
    config.setDriverClassName("com.mysql.jdbc.Driver");

    config.setUsername(this.user);
    config.setPassword(this.password);

    config.addDataSourceProperty("cachePrepStmts", true);
    config.addDataSourceProperty("prepStmtCacheSize", 250);
    config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
    config.addDataSourceProperty("useServerPrepStmts", true);
    config.addDataSourceProperty("useLocalSessionState", true);
    config.addDataSourceProperty("useLocalTransactionState", true);
    config.addDataSourceProperty("rewriteBatchedStatements", true);
    config.addDataSourceProperty("cacheResultSetMetadata", true);
    config.addDataSourceProperty("cacheServerConfiguration", true);
    config.addDataSourceProperty("elideSetAutoCommits", true);
    config.addDataSourceProperty("maintainTimeStats", false);
    config.setMaxLifetime(0);
    config.setConnectionTimeout(60000);
    config.setValidationTimeout(3000);
    config.setMaximumPoolSize(10);

    return config;
  }

  public void connect() {
    this.sqlDatabase = new SQLDatabaseImpl(config());
  }

  public SQLDatabase getSQLDatabase() {
    return this.sqlDatabase;
  }

}
