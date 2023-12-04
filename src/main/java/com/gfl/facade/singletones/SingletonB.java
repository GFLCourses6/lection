package com.gfl.facade.singletones;

public class SingletonB {
    private static SingletonB singletonB;

    private SingletonB() {
    }

    public synchronized static SingletonB getInstance() {
        synchronized (SingletonB.class) {
            if (singletonB == null) {
                singletonB = new SingletonB();
            }
            return singletonB;
        }
    }

    public void action() {
        System.out.println("Singleton B - action 1");
    }
}
