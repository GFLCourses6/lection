package com.ua.proxy.service;

public class ExpensiveObjectProxy
        implements ExpensiveObject {

    private ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectReal();
        }
        object.process();
    }
}
