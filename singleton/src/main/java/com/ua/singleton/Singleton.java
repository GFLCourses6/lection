package com.ua.singleton;

public class Singleton {
    private String value;

    public Singleton(String value) {
        this.value = value;
    }

    private Singleton() {
        this.value = "Initial";
    }

    private static final class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(String value) {
        if (value != null) {
            synchronized (Singleton.class) {
                SingletonHolder.INSTANCE.value = value;
            }
        }
        return SingletonHolder.INSTANCE;
    }

    public String getValue() {
        return value;
    }
}
