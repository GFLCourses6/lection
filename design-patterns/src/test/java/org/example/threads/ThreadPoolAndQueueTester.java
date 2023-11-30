package org.example.threads;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.*;

public class ThreadPoolAndQueueTester {
    private static final Queue<String> SCENARIO_QUEUE = new ConcurrentLinkedQueue<>();
    private static final Queue<String> PROXY_QUEUE = new ConcurrentLinkedQueue<>();
    private static final CountDownLatch CDL = new CountDownLatch(8);

    @Test
    public void threadAndQueue() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable qaEngineersSendScenarios = () -> {
            System.out.println(Thread.currentThread().getName() + " QA submit scenario");

            for (int i = 0; i < 10; i++) {
                String scenario = "Scenario = " + i;
                SCENARIO_QUEUE.add(scenario);
                try {
                    TimeUnit.SECONDS.sleep(1); // Reduced sleep time for faster demonstration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            CDL.countDown();
        };

        Runnable proxyParsing = () -> {
            System.out.println(Thread.currentThread().getName() + " started proxy parsing");

            for (int i = 0; i < 10; i++) {
                String proxy = "Proxy = " + i;
                PROXY_QUEUE.add(proxy);
                try {
                    TimeUnit.MILLISECONDS.sleep(500); // Reduced sleep time for faster demonstration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            CDL.countDown();
        };

        executorService.submit(qaEngineersSendScenarios);
        executorService.submit(proxyParsing);

        int amountOfWorkers = 6;

        for (int workersCounter = 1; workersCounter <= amountOfWorkers; workersCounter++) {
            Runnable worker = () -> {
                for (int i = 0; i < 10; i++) {
                    String proxyToUseWebDriver = PROXY_QUEUE.poll();
                    if (proxyToUseWebDriver == null) {
                        continue;
                    }
                    String scenarioToExecute = SCENARIO_QUEUE.poll();
                    if (scenarioToExecute == null) {
                        continue;
                    }
                    System.out.println("Worker within Thread " +
                            Thread.currentThread().getName() +
                            " running using proxy = " + proxyToUseWebDriver +
                            " and scenario " + scenarioToExecute);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200); // Reduced sleep time for faster demonstration
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                CDL.countDown();
            };
            executorService.submit(worker);
        }
        CDL.await();
        executorService.shutdown();
    }
}