package com.vladproduction.app04;

public class SingletonB {
    private final String value;
    private static SingletonB instance;

    private SingletonB(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static SingletonB getInstance(String value){
        if(instance==null){
            instance = new SingletonB(value);
        }
        return instance;
    }
}
