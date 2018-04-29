package com.moizdrajcy.toolsapi.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.intellij.lang.annotations.Language;

public class DatabaseImpl implements Database {

  private final HikariDataSource dataSource;

  public DatabaseImpl(HikariConfig config) {
    this.dataSource = new HikariDataSource(config);
  }

  @Override
  public void update(String query) throws DatabaseException {
    try (Connection connection = this.dataSource.getConnection()) {
      connection.prepareStatement(query).executeUpdate();
    } catch (SQLException ex) {
      throw new DatabaseException(ex);
    }
  }

  @Override
  public ResultSet query(String query) throws DatabaseException {
    try {
      return this.dataSource.getConnection().prepareStatement(query).executeQuery();
    } catch (SQLException ex) {
      throw new DatabaseException(ex);
    }
  }

}
