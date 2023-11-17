package com.ua.facade.action;

public class SingletonDataBase
        implements Singleton {
    private Integer value;

    public SingletonDataBase(Integer value) {
        this.value = value;
    }

    private SingletonDataBase() {
        this.value = 0;
    }

    @Override
    public Integer action() {
        value++;
        System.out.printf("Action: %d%n", getValue());
        return value;
    }

    private static final class Holder {
        private static final SingletonDataBase INSTANCE = new SingletonDataBase();
    }

    public static SingletonDataBase getInstance(Integer value) {
        if (value != null) {
            synchronized (SingletonDataBase.class) {
                Holder.INSTANCE.value = value;
            }
        }
        return Holder.INSTANCE;
    }

    public Integer getValue() {
        return value;
    }
}
