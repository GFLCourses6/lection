package com.gfl.prokhnov.singleton.threadSafe;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ThreadSafeSingletonApp {

    private static final Logger LOGGER = LogManager.getLogger(ThreadSafeSingletonApp.class.getName());

    public static void main(String[] args) {
        ThreadSafeSingletonApp threadSafeSingletonApp = new ThreadSafeSingletonApp();
        threadSafeSingletonApp.run();

    }

    private void run() {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        threadOne.start();
        threadTwo.start();
    }

    static class ThreadOne implements Runnable{

        @Override
        public void run() {
            ThreadSafeSingleton test1 = ThreadSafeSingleton.getInstance("One");
            LOGGER.info(test1.getValue());
        }
    }

    static class ThreadTwo implements Runnable{

        @Override
        public void run() {
            ThreadSafeSingleton test1 = ThreadSafeSingleton.getInstance("Two");
            LOGGER.info(test1.getValue());
        }
    }
}
