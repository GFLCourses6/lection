import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.*;

//The code only works as intended using Java 8
//In other cases, the test works correctly, but the text is not displayed on the screen after continue keyword


public class ThreadPoolAndQueueTester {

    private static final Queue<String> SCENARIO_QUEUE = new ConcurrentLinkedQueue<>();
    private static final Queue<String> PROXY_QUEUE = new ConcurrentLinkedQueue<>();
    private static final CountDownLatch CDL = new CountDownLatch(8);

    @Test
    public void threadAndQueue() throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable qaEngineersSendScenarios = () -> {
            System.out.println(Thread.currentThread().getName() + " Qa submit scenario");

            for (int i = 0; i < 10; i++) {
                String scenario = "Scenario = " + i;
                SCENARIO_QUEUE.add(scenario);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            CDL.countDown();

        };

        Runnable proxyParsing = () -> {
            System.out.println(Thread.currentThread().getName() + " Started proxy parsing");

            for (int i = 0; i < 10; i++) {
                String proxy = "Proxy = " + i;
                PROXY_QUEUE.add(proxy);

                try {
                    TimeUnit.SECONDS.sleep(1);
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
                    String proxyToUseForWebDriver = PROXY_QUEUE.poll();

                    if (proxyToUseForWebDriver == null) continue;
                    // Initialize webDriver
                    String scenarioToExecute = SCENARIO_QUEUE.poll();

                    if (scenarioToExecute == null) continue;

                    System.out.println("I'm worker within thread "
                            + Thread.currentThread().getName()
                            + " Running using proxy = "
                            + proxyToUseForWebDriver
                            + " and scenario "
                            + scenarioToExecute);

                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                CDL.countDown();
            };
            executorService.submit(worker);
        }

        CDL.await();
    }
}
