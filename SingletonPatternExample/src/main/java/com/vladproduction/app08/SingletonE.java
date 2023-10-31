package com.vladproduction.app08;

public class SingletonE {

    private SingletonE(){}

    private static class LazyHolder{
        static SingletonE instance = new SingletonE();
    }

    public static SingletonE getInstance(){
        return LazyHolder.instance;
    }
}
