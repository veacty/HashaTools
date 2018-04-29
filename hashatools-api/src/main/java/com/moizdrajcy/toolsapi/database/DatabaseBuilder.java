package com.moizdrajcy.toolsapi.database;

import com.google.common.base.Preconditions;
import com.zaxxer.hikari.HikariConfig;

public final class DatabaseBuilder {

  private Database database;
  private HikariConfig config;

  public static DatabaseBuilder create() {
    return new DatabaseBuilder();
  }

  public DatabaseBuilder setup(DatabaseSettings settings) {
    this.config = new HikariConfig();

    this.config.setJdbcUrl("jdbc:mysql://" + settings.getHost() + ":" + settings.getPort() + "/" + settings.getDatabase());
    this.config.setUsername(settings.getUsername());
    this.config.setPassword(settings.getPassword());

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

    return this;
  }

  public DatabaseBuilder connect() {
    this.database = new DatabaseImpl(this.config);

    return this;
  }

  public DatabaseBuilder createTables() {
    Preconditions.checkNotNull(this.database);

    this.database.update(
        "CREATE TABLE IF NOT EXISTS `tools_users` (" +
            "`uuid` BINARY(16) NOT NULL," +
            "PRIMARY KEY(UUID));");

    return this;
  }

  public Database build() {
    Preconditions.checkNotNull(this.database);

    return this.database;
  }

}
