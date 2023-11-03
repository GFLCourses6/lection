package com.classwork.pattern.facade.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class TransactionManagerService {
    private final DataSource dataSource;
    private final ThreadLocal<Connection> threadLocal = ThreadLocal.withInitial(() -> null);
    private static final Logger LOGGER = LogManager.getLogger(TransactionManagerService.class);

    public TransactionManagerService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void begin() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        Connection connection = getConnection();
        connection.commit();
        connection.setAutoCommit(true);
    }

    public void rollback() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void close() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                connection.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private Connection getConnection()
            throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
}
