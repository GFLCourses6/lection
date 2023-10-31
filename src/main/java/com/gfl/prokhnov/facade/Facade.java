package com.gfl.prokhnov.facade;

public class Facade {
    private final SingletonOne singletonOne;
    private final SingletonTwo singletonTwo;

    public Facade() {
        this.singletonOne = SingletonOne.getInstance();
        this.singletonTwo = SingletonTwo.getInstance();
    }

    public void callSingletons(){
        singletonOne.action();
        singletonTwo.action();
    }
}
