package org.example.singleton;

public class Singleton {
    private String value;

    private Singleton() {}

    public Singleton(String value) {
        this.value = value;
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

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
