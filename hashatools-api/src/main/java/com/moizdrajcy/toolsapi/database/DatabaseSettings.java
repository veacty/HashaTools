package com.moizdrajcy.toolsapi.database;

public class DatabaseSettings {

  private String host;
  private int port;
  private String database;
  private String username;
  private String password;

  public DatabaseSettings() {
    this.host = "localhost";
    this.port = 3306;
    this.username = "root";
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
