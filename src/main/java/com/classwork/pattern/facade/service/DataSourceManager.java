package com.classwork.pattern.facade.service;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

public class DataSourceManager {

    private DataSource dataSource;

    public DataSourceManager() {
        initDataSource();
    }

    private void initDataSource() {
        JdbcDataSource h2DataSource = new JdbcDataSource();
        h2DataSource.setURL("jdbc:h2:mem:testdb");
        h2DataSource.setUser("sa");
        h2DataSource.setPassword("");
        dataSource = h2DataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
