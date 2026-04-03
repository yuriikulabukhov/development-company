package com.solvd.developmentcompany.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);
    private static final int POOL_SIZE = 5;
    private static volatile ConnectionPool instance;
    private final BlockingQueue<MyConnection> pool;

    private ConnectionPool() {
        pool = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 1; i <= POOL_SIZE; i++) {
            pool.add(new MyConnection(i));
        }
        LOGGER.info("ConnectionPool initialized with " + POOL_SIZE + " connections.");
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public MyConnection getConnection() {
        try {
            LOGGER.info(" " + Thread.currentThread().getName() + " requesting connection. "
                    + "Available: " + pool.size());
            MyConnection conn = pool.take();  // WAITS if pool is empty
            LOGGER.info(" " + Thread.currentThread().getName() + " got " + conn
                    + ". Remaining: " + pool.size());
            return conn;
        } catch (InterruptedException e) {
            LOGGER.error("Error getting connection", e);
            return null;
        }
    }

    public void releaseConnection(MyConnection connection) {
        if (connection != null) {
            pool.offer(connection);
            LOGGER.info("[" + Thread.currentThread().getName() + "] returned " + connection
                    + ". Available: " + pool.size());
        }
    }

    public int getAvailableConnections() {
        return pool.size();
    }
}
