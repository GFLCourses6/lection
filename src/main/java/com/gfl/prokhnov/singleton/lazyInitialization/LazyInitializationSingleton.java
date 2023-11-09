package com.gfl.prokhnov.singleton.lazyInitialization;

public class LazyInitializationSingleton {
    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton() {
    }

    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            return new LazyInitializationSingleton();
        }
        return instance;
    }
}
