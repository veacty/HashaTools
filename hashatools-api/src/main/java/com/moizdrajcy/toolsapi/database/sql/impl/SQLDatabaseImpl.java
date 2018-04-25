package com.moizdrajcy.toolsapi.database.sql.impl;

import com.moizdrajcy.toolsapi.database.DatabaseException;
import com.moizdrajcy.toolsapi.database.sql.SQLDatabase;
import com.moizdrajcy.toolsapi.database.sql.SQLDatabaseConsumer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLDatabaseImpl implements SQLDatabase {

  private final HikariDataSource dataSource;

  public SQLDatabaseImpl(HikariConfig config) {
    this.dataSource = new HikariDataSource(config);
  }

  @Override
  public void update(String query) throws DatabaseException {
    try (PreparedStatement statement = this.dataSource.getConnection().prepareStatement(query)) {
      statement.executeUpdate();
    } catch (SQLException ex) {
      throw new DatabaseException(ex);
    }
  }

  @Override
  public void update(String query, SQLDatabaseConsumer consumer) throws DatabaseException {
    try (PreparedStatement statement = this.dataSource.getConnection().prepareStatement(query)) {
      consumer.accept(statement);

      statement.executeUpdate();
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

  @Override
  public ResultSet query(String query, SQLDatabaseConsumer consumer) throws DatabaseException {
    try (PreparedStatement statement = this.dataSource.getConnection().prepareStatement(query)) {
      consumer.accept(statement);

      return statement.executeQuery();
    } catch (SQLException ex) {
      throw new DatabaseException(ex);
    }

  }

}
