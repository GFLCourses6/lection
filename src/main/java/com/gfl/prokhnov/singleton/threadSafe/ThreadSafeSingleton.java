package com.gfl.prokhnov.singleton.threadSafe;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private String value;

    public ThreadSafeSingleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        this.value = value;
    }

    public static ThreadSafeSingleton getInstance(String value) {
        synchronized ((ThreadSafeSingleton.class)) {
            if (instance == null) {
                instance = new ThreadSafeSingleton(value);
            }
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

}