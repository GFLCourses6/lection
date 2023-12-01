package org.example.interrupt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class InterruptedExample  {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch mainCDL = new CountDownLatch(1);
        CountDownLatch awaitCDL = new CountDownLatch(1); // to stop and continue work in thread

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Interrupted status on startup = " + Thread.currentThread().isInterrupted());
                int i = 0;
                while(!Thread.currentThread().isInterrupted()){
                    try {
                        System.out.println("Do some work..." + i++);
                        awaitCDL.countDown(); // CDL скидывается до 0
                        TimeUnit.SECONDS.sleep(3); // ждем 3 сек и тут прерываем
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                        System.out.println("Thread name = " + Thread.currentThread().getName());
                        System.out.println("Interrupted status after exception = " + Thread.currentThread().isInterrupted());
                        // статус сам не меняется потому что в мейне он уже интераптед, а тут нет
                        Thread.currentThread().interrupt(); // если закоментить то оно не остановится
                        System.out.println("Interrupted status after change status = " + Thread.currentThread().isInterrupted());
                    }
                }
                mainCDL.countDown();
            }
        }; // this is our worker which do some work

        Thread thread = new Thread(runnable);
        thread.start(); // запускаем воркер
        System.out.println("MAIN Thread name  = " + thread.getName());

        awaitCDL.await(); // ждем пока наша CDL скинется до 0 и ждем 3 сек
        thread.interrupt(); // после того как скинулись перерываем этот thread
        System.out.println("MAIN Interrupted status after change status = " + thread.isInterrupted());
        mainCDL.await(); // ждем пока CDL отработает
        System.out.println("MAIN Interrupted status after change status = " + thread.isInterrupted());
        System.out.println("Application completed");
    }
}
