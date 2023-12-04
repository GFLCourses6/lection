package com.gfl.facade.singletones;

public class SingletonC {
    private static SingletonC singletonC;

    private SingletonC() {
    }

    public synchronized static SingletonC getInstance() {
        synchronized (SingletonC.class) {
            {
                if (singletonC == null) {
                    singletonC = new SingletonC();
                }
                return singletonC;
            }
        }
    }

    public void action() {
        System.out.println("Singleton C - action 1");
    }
}
