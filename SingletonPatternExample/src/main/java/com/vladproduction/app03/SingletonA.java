package com.vladproduction.app03;

public class SingletonA {
    private static volatile SingletonA instance;

    private SingletonA(){
        if(instance != null){
            throw new RuntimeException("use getInstance() method");
        }
    }

    public static SingletonA getInstance() {
        if(instance == null){
            synchronized (SingletonA.class){
                if(instance == null){
                    instance = new SingletonA();
                }
            }
        }
        return instance;
    }
}
