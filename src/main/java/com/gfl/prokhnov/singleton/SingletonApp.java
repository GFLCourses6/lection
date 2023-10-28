package com.gfl.prokhnov.singleton;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SingletonApp {

    private static final Logger LOGGER = LogManager.getLogger(SingletonApp.class.getName());

    public static void main(String[] args) {
        SingletonApp singletonApp = new SingletonApp();
        singletonApp.run();

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
            Singleton test1 = Singleton.getInstance("One");
            LOGGER.info(test1.getValue());
        }
    }

    static class ThreadTwo implements Runnable{

        @Override
        public void run() {
            Singleton test1 = Singleton.getInstance("Two");
            LOGGER.info(test1.getValue());
        }
    }
}
