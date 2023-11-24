package com.gfl.proxy.datasource;

import com.gfl.proxy.model.ProxyConnection;
import lombok.SneakyThrows;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class PooledDataSource extends PGSimpleDataSource {

    private final int INITIAL_POOL_SIZE = 10;
    private final Queue<Connection> connectionPool;
    private final Semaphore semaphore;

    @SneakyThrows
    public PooledDataSource(String url, String username, String password) {
        setUrl(url);
        setUser(username);
        setPassword(password);
        connectionPool = new ConcurrentLinkedQueue<>();
        semaphore = new Semaphore(INITIAL_POOL_SIZE, true);

        // insert proxy connections into connection pool
        fillConnectionPool(INITIAL_POOL_SIZE);
    }

    /**
     * If semaphore's total current permits = 0, then it means that the CP is empty &
     * other threads will be blocked from execution of this method unless some other thread
     * invokes the release method for this semaphore and the current thread is next to be assigned a permit.
     * The release method for this semaphore is called in {@link ProxyConnection#close()}
     * @return Connection from the {@link PooledDataSource#connectionPool}
     */
    @Override
    public Connection getConnection() {
        try {
            semaphore.acquire();
            System.out.println(semaphore.availablePermits()); // to delete
            return connectionPool.poll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private void fillConnectionPool(int size) {
        for (int i = 0; i < size; i++) {
            Connection proxyConnection = new ProxyConnection(super.getConnection(), connectionPool, semaphore);
            connectionPool.add(proxyConnection);
        }
    }
}
