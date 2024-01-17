package ua.chemerys;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class InterruptedExceptionApp {

    private static CountDownLatch mainCDL = new CountDownLatch(1);

    private static CountDownLatch awaitCDL = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(getRunnable());
        thread.start();

        System.out.println("The name of the current thread in main is " + thread.getName());

        awaitCDL.await();
        thread.interrupt();
        System.out.println("And here we can see main interrupted status after changing status manually. " +
                "And it is " + thread.isInterrupted());
        mainCDL.await();

        System.out.println("And here application completed");
    }

    private static Runnable getRunnable() {

        return () -> {
            System.out.println("Interrupted status on startup is " + Thread.currentThread().isInterrupted());
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Imitation of doing some real work..." + i++);
                    awaitCDL.countDown();
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    System.out.println("And here we catch interrupted exception");
                    System.out.println("The name of the current thread is " + Thread.currentThread().getName());
                    System.out.println("Let's look at interrupted status after exception. And it is "
                            + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("And here we can see interrupted status after changing status manually. " +
                            "And it is " + Thread.currentThread().isInterrupted());
                }
            }

            mainCDL.countDown();
        };
    }
}