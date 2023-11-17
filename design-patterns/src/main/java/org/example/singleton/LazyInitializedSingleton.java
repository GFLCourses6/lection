package org.example.singleton;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    private String value;

    public LazyInitializedSingleton(String value) {
        this.value = value;
    }

    public static synchronized LazyInitializedSingleton getInstance(String value) {
        if (instance == null) {
            instance = new LazyInitializedSingleton(value);
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
