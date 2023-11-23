package com.ua.threads;

import org.junit.jupiter.api.Test;

class MultiThreadPoolTest {

    @Test
    void testMultiThreadPool()
            throws Exception {
        MultiThreadPool threadPool = new MultiThreadPool();
        threadPool.threadAndQueue();
    }
}