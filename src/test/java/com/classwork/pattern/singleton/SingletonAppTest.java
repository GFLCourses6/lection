package com.classwork.pattern.singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class SingletonAppTest {

    @Test
    void testSingletonInstance() {
        Singleton singleton1 = Singleton.getInstance("Test");
        Singleton singleton2 = Singleton.getInstance("Value");

        assertSame(singleton1,
                   singleton2);
        assertEquals("Value",
                     singleton1.getValue());
    }

    @Test
    void testSingleton() {
        Singleton singleton1 = Singleton.getInstance("Test1");
        assertEquals("Test1",
                     singleton1.getValue());

        Singleton singleton2 = Singleton.getInstance(null);
        assertEquals("Test1",
                     singleton2.getValue());

        Singleton singleton3 = Singleton.getInstance("Test2");
        assertEquals("Test2", singleton3.getValue());

        assertSame(singleton1, singleton2);
        assertSame(singleton2, singleton3);
    }

    @Test
    void testThreadSafety()
            throws InterruptedException {

        int numThreads = Runtime.getRuntime().availableProcessors();
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(numThreads);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Singleton[] singletons = new Singleton[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    startLatch.await();
                    singletons[index] = Singleton.getInstance("Value" + index);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    endLatch.countDown();
                }
            });
        }

        startLatch.countDown();

        endLatch.await();

        for (Singleton instance : singletons) {
            assertSame(singletons[0], instance);
        }

        executor.shutdown();

    }
}