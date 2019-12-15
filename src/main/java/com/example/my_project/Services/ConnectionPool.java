package com.example.my_project.Services;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool instance = new ConnectionPool();
    private HikariConfig conf;
    private HikariDataSource dataSource;

    private ConnectionPool(){
        conf = new HikariConfig();
        conf.setJdbcUrl(ConfigReader.getProperty("url"));
        conf.setUsername(ConfigReader.getProperty("user"));
        conf.setPassword(ConfigReader.getProperty("password"));
        dataSource = new HikariDataSource(conf);
    }

    public static ConnectionPool getInstance(){
        return instance;
    }

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
