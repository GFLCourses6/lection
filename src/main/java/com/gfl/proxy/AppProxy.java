package com.gfl.proxy;

import com.gfl.proxy.datasource.PooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppProxy {

    PooledDataSource dataSource;

    public static void main(String[] args) {
        AppProxy app = new AppProxy();
        app.run();
    }

    public void run() {
        dataSource = new PooledDataSource(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres"
        );

        ExecutorService executor = Executors.newFixedThreadPool(15); // but, INITIAL_POOL_SIZE = 10
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try (Connection connection = dataSource.getConnection()) {
                    String sql = "SHOW ALL;";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.executeQuery();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();;
                }
            });
        }
        executor.shutdown();
    }
}
