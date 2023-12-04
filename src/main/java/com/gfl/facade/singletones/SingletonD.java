package com.gfl.facade.singletones;

public class SingletonD {
    private static SingletonD singletonD;

    private SingletonD() {
    }

    public synchronized static SingletonD getInstance() {
        synchronized (SingletonD.class) {
            if (singletonD == null) {
                singletonD = new SingletonD();
            }
        }
        return singletonD;
    }

    public void action() {
        System.out.println("Singleton D - action 1");
    }
}
