package com.vladproduction.dbApp.service;

import com.vladproduction.utils.ConfigUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceManagerImpl implements DataSourceManager {
    @Override
    public Connection getConnection() throws SQLException {
        String url = ConfigUtils.getConfigProperty("DB.url");
        String login = ConfigUtils.getConfigProperty("DB.login");
        String password = ConfigUtils.getConfigProperty("DB.password");
        return DriverManager.getConnection(url,login,password);
    }
}




