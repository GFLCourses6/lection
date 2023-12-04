package com.gfl.facade.singletones;

public class SingletonA {
    private static SingletonA singletonA;

    private SingletonA() {
    }

    public static SingletonA getInstance() {
        synchronized (SingletonA.class) {
            if (singletonA == null) {
                singletonA = new SingletonA();
            }
            return singletonA;
        }
    }

    public void action() {
        System.out.println("Singleton A - action 1");
    }
}
