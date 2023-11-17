package org.example.singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private String value;

    private ThreadSafeSingleton(String value) {
        this.value = value;
    }

    public static ThreadSafeSingleton getInstance(String value) {
        synchronized (ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return value;
    }
}
