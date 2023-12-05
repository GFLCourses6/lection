package com.ua.db.service;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceManagerService
        implements DataSourceManager {
    @Override
    public Connection getConnection() {
        final String url = "jdbc:postgresql://oregon-postgres.render.com:5432/store_ih9m?user=admin&password=KuvTJNHx6eapfdIpX03nFOZwjvVHA0n";
        try {
            final PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setURL(url);
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
