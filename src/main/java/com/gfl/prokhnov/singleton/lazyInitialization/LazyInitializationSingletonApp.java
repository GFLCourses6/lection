package com.gfl.prokhnov.singleton.lazyInitialization;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LazyInitializationSingletonApp {

    private static final Logger LOGGER = LogManager.getLogger(LazyInitializationSingletonApp.class.getName());

    public static void main(String[] args) {
        LazyInitializationSingletonApp lazyInitializationSingletonApp = new LazyInitializationSingletonApp();
        lazyInitializationSingletonApp.run();
    }

    private void run() {

        LazyInitializationSingleton instance1 = LazyInitializationSingleton.getInstance();
        LazyInitializationSingleton instance2 = LazyInitializationSingleton.getInstance();
        LOGGER.info(instance1);
        LOGGER.info(instance2);
    }
}
