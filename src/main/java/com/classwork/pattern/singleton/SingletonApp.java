package com.classwork.pattern.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingletonApp {
    private static final Logger LOGGER = LogManager.getLogger(SingletonApp.class);

    public static void main(String[] args) {
        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new ThreadTwo());

        one.start();
        two.start();
    }

    static class ThreadTwo
            implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Runnable");
            LOGGER.info(singleton.getValue());
        }
    }

    static class ThreadOne
            implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Thread");
            LOGGER.info(singleton.getValue());
        }
    }
}
