package org.example.executorExample;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
//        Executor executor = Executors.newSingleThreadExecutor(); // по дефолту создвет один Thread
//        executor.execute(() -> System.out.println("Separate Thread" + Thread.currentThread().getName()));
//        System.out.println("Main Thread " + Thread.currentThread().getName());
//
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(2); // scheduled
//        service.schedule(() -> System.out.println("Hello World"), 3, TimeUnit.SECONDS);

//        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(2); // scheduled 2 sec with period 1
//        service1.scheduleAtFixedRate(() -> System.out.println("Hello World"), 2, 1, TimeUnit.SECONDS);

        CountDownLatch countDownLatch = new CountDownLatch(6);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.
                scheduleAtFixedRate(() -> {
                            System.out.println("Hello World");
                            countDownLatch.countDown();
                        },
                        2, 1, TimeUnit.SECONDS);
        countDownLatch.await(4, TimeUnit.SECONDS);
        scheduledFuture.cancel(true);
    }
}
