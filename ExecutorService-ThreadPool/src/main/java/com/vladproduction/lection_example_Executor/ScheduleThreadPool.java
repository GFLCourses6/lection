package com.vladproduction.lection_example_Executor;

import java.util.concurrent.*;

public class ScheduleThreadPool {
    public static void main(String[] args) throws InterruptedException {


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.schedule(() -> System.out.println("Task#1"), 2, TimeUnit.SECONDS);

        CountDownLatch cdl = new CountDownLatch(5);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService
                .scheduleAtFixedRate(() -> {
                    System.out.println("Task-Fixed-Rate: #" + cdl);
                    cdl.countDown();
                }, 2, 1, TimeUnit.SECONDS);
        cdl.await();
        scheduledFuture.cancel(true);
        scheduledExecutorService.shutdown();


    }
}
