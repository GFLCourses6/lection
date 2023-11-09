package com.gfl.prokhnov.singleton.eagerInitialization;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EagerInitializationSingletonApp {
    private static final Logger LOGGER = LogManager.getLogger(EagerInitializationSingletonApp.class.getName());

    public static void main(String[] args) {
        EagerInitializationSingletonApp eagerInitializationSingletonApp
                = new EagerInitializationSingletonApp();
        eagerInitializationSingletonApp.run();
    }

    private void run() {
        EagerInitializationSingleton instance1 = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton instance2 = EagerInitializationSingleton.getInstance();

        LOGGER.info(instance1);
        LOGGER.info(instance2);
    }
}
