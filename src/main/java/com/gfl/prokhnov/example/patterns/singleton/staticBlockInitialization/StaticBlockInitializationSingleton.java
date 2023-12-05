package com.gfl.prokhnov.example.patterns.singleton.staticBlockInitialization;

public class StaticBlockInitializationSingleton {
    private static final StaticBlockInitializationSingleton instance;

    private StaticBlockInitializationSingleton() {
    }

    // Similar to Eager initialization but there we can provide exception handling
    static {
        try {
            instance = new StaticBlockInitializationSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockInitializationSingleton getInstance() {
        return instance;
    }
}
