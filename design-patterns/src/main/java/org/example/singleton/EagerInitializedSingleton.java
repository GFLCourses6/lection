package org.example.singleton;

public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    private String value;


    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    public String getStringValue() {
        return value;
    }

    public void setStringValue(String value) {
        this.value = value;
    }
}
