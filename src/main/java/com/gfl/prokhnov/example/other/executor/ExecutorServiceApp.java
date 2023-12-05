package com.gfl.prokhnov.example.other.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceApp {
    public static void main(String[] args) throws InterruptedException {
        // create 1 Thread
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(() -> System.out.println("Hello world!" + Thread.currentThread().getName()));
//        System.out.println("Main Thread -> " + Thread.currentThread().getName());

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() -> System.out.println("Hello World"), 2, TimeUnit.SECONDS);

        CountDownLatch countDownLatch = new CountDownLatch(5);
        ScheduledExecutorService scheduledAndFixedRateExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> scheduledFuture = scheduledAndFixedRateExecutorService.
                scheduleAtFixedRate(() -> {
                    System.out.println("-> Hello World");
                    countDownLatch.countDown();
                }, 3, 2, TimeUnit.SECONDS);
        countDownLatch.await();
        scheduledFuture.cancel(true);

    }
}
