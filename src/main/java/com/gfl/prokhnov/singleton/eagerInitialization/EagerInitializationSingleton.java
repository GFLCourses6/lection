package com.gfl.prokhnov.singleton.eagerInitialization;

public class EagerInitializationSingleton {
    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();

    private EagerInitializationSingleton() {
    }

    public static EagerInitializationSingleton getInstance() {
        return instance;
    }
}
