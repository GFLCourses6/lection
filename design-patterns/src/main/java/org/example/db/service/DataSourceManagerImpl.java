package org.example.db.service;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceManagerImpl implements DataSourceManager{
    @Override
    public Connection getConnection() throws SQLException {
        final String url ="jdbc:postgresql://localhost:5432/encyclopedia?user=postgres&password=1234";
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(url);
        return dataSource.getConnection();
    }
}
