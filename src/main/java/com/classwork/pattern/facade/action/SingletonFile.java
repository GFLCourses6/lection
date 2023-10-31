package com.classwork.pattern.facade.action;

public class SingletonFile
        implements Singleton {
    private Integer value;

    public SingletonFile(Integer value) {
        this.value = value;
    }

    private SingletonFile() {
        this.value = 0;
    }

    @Override
    public Integer action() {
        value++;
        System.out.printf("Action: %d%n", getValue());
        return value;
    }

    private static final class Holder {
        private static final SingletonFile INSTANCE = new SingletonFile();
    }

    public static SingletonFile getInstance(Integer value) {
        if (value != null) {
            synchronized (SingletonFile.class) {
                SingletonFile.Holder.INSTANCE.value = value;
            }
        }
        return SingletonFile.Holder.INSTANCE;
    }

    public Integer getValue() {
        return value;
    }
}
