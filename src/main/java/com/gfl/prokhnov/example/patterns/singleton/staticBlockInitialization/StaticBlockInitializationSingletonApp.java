package com.gfl.prokhnov.example.patterns.singleton.staticBlockInitialization;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class StaticBlockInitializationSingletonApp {

    private static final Logger LOGGER = LogManager.getLogger(StaticBlockInitializationSingletonApp.class.getName());

    public static void main(String[] args) {
        StaticBlockInitializationSingletonApp staticBlockInitializationSingletonApp
                = new StaticBlockInitializationSingletonApp();
        staticBlockInitializationSingletonApp.run();
    }

    public void run() {

        StaticBlockInitializationSingleton instance1 = StaticBlockInitializationSingleton.getInstance();
        StaticBlockInitializationSingleton instance2 = StaticBlockInitializationSingleton.getInstance();

        LOGGER.info(instance1);
        LOGGER.info(instance2);

    }
}
