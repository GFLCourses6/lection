package com.ua.facade.action;

public class SingletonConsole
        implements Singleton {

    private Integer value;

    public SingletonConsole(Integer value) {
        this.value = value;
    }

    private SingletonConsole() {
        this.value = 0;
    }

    @Override
    public Integer action() {
        value++;
        System.out.printf("Action: %d%n", getValue());
        return value;
    }

    private static final class Holder {
        private static final SingletonConsole INSTANCE = new SingletonConsole();
    }

    public static SingletonConsole getInstance(Integer value) {
        if (value != null) {
            synchronized (SingletonConsole.class) {
                Holder.INSTANCE.value = value;
            }
        }
        return Holder.INSTANCE;
    }

    public Integer getValue() {
        return value;
    }
}