package com.gfl.prokhnov.example.other.executor;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExecutoThreadPoolTest {

    @Test
    void fixedThreadPoolExecutorTest() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        assertEquals(2, executorService.getPoolSize());
        assertEquals(1, executorService.getQueue().size());

    }

    @Test
    void fixedThreadPoolExecutorGetResultTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(() -> "Hello world");
        String s = submit.get();
        assertEquals("Hello world", s);
    }

    @Test
    void cachedThreadPoolExecutorGetResultTest() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        assertEquals(3, executorService.getPoolSize());
        assertEquals(0, executorService.getQueue().size());
    }

    @Test
    void scheduleThreadPoolExecutorGetResultTest() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() -> System.out.println("Hello World"), 2, TimeUnit.SECONDS);
    }

    @Test
    void atomicThreadPoolExecutorGetResultTest() throws ExecutionException, InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Future<?> submit = executor.submit(() -> atomicInteger.set(1));
        Future<?> submit1 = executor.submit(() -> atomicInteger.set(2));

        submit.get();
        submit1.get();

        assertEquals(2,atomicInteger.get());
    }
}