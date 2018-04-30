package com.moizdrajcy.toolsapi.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    try (Connection connection = this.dataSource.getConnection()) {
      return connection.prepareStatement(query).executeQuery();
    } catch (SQLException ex) {
      throw new DatabaseException(ex);
    }
  }

}
