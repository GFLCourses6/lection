package com.classwork.pattern.proxy.service.sql;

import com.classwork.pattern.facade.service.DataSourceManager;
import com.classwork.pattern.facade.service.TransactionManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnectionPostgreSqlService
        implements DbConnectionService {
    private final DataSource dataSource;

    private final TransactionManagerService transactionManager;

    private static final Logger LOGGER =
            LogManager.getLogger(DbConnectionPostgreSqlService.class);

    public DbConnectionPostgreSqlService() {
        this.dataSource = new DataSourceManager().getDataSource();
        this.transactionManager = new TransactionManagerService(dataSource);
    }

    @Override
    public String invoke(String sql) {
        try (Connection connection = dataSource.getConnection()) {
            transactionManager.begin();
            return findBy(sql, connection);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            transactionManager.rollback();
        } finally {
            transactionManager.close();
        }
        return null;
    }

    private String findBy(
            String sql,
            Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                sql); ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String result = resultSet.getString(1);
                transactionManager.commit();
                return result;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            transactionManager.rollback();
        }
        return "";
    }
}
