package com.gfl.prokhnov.singleton;

public class Singleton {
    private static Singleton instance;
    private String value;

    public Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        synchronized ((Singleton.class)) {
            if (instance == null) {
                instance = new Singleton(value);
            }
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

}