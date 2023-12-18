package com.vladproduction.lection_example_Executor;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FixedThreadPoolExecutorTest {

    @Test
    public void fixedThreadPoolExecutorTest() {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });

        int poolSize = executorService.getCorePoolSize();
        int queueSize = executorService.getQueue().size();

        System.out.println("poolSize = " + poolSize);
        System.out.println("queueSize = " + queueSize);

        assertEquals(2, poolSize);
        assertEquals(3, queueSize);


    }

    @Test
    public void fixedThreadPoolExecutorGetResultTest() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(() -> "HelloWorld");
        String s = submit.get();
        assertEquals("HelloWorld", s);

    }

    @Test
    public void cashedThreadPoolExecutorGetResultTest() {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) new ThreadPoolExecutor(0, 4,
                60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
//        executorService.submit(()->{
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//            return null;
//        });

        int poolSize = executorService.getPoolSize();
        int queueSize = executorService.getQueue().size();

        System.out.println("poolSize = " + poolSize);
        System.out.println("queueSize = " + queueSize);

        assertEquals(4, poolSize);
        assertEquals(0, queueSize);

    }

    @Test
    public void scheduleThreadPoolExecutorGetResultTest() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.schedule(() -> System.out.println("Task#1"), 2, TimeUnit.SECONDS);


    }

    @Test
    public void atomicThreadPoolExecutorGetResultTest() throws ExecutionException, InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();


        Future<?> submit = executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            atomicInteger.set(2);
        });
        submit.get();

        Future<?> submit2 = executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            atomicInteger.compareAndSet(0, 3);
        });
        submit2.get();

        Future<?> submit3 = executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            atomicInteger.compareAndSet(1, 2);
        });
        submit3.get();

        assertEquals(2, atomicInteger.get());
    }
}