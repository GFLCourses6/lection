package com.gfl.prokhnov.example.patterns.facade;

public class SingletonOne {
    private static SingletonOne instance;

    public SingletonOne() {

    }

    public static SingletonOne getInstance() {
        if (instance == null) {
            instance = new SingletonOne();
        }
        return instance;
    }

    public void action() {
        System.out.println("Action 1");
    }
}
