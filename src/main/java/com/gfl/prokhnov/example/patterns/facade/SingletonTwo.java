package com.gfl.prokhnov.example.patterns.facade;

public class SingletonTwo {
    private static SingletonTwo instance;

    public SingletonTwo() {

    }

    public static SingletonTwo getInstance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }

    public void action() {
        System.out.println("Action 2");
    }
}
