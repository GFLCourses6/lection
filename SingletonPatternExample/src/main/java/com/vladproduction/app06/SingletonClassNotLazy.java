package com.vladproduction.app06;

public class SingletonClassNotLazy {

    private static SingletonClassNotLazy instance = new SingletonClassNotLazy();

    private SingletonClassNotLazy(){}

    public static SingletonClassNotLazy getInstance(){

        return instance;
    }

}
