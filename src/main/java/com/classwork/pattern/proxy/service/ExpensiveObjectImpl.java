package com.classwork.pattern.proxy.service;

public class ExpensiveObjectImpl
        implements ExpensiveObject {
    public ExpensiveObjectImpl() {
        heavyInitConfig();
    }

    private void heavyInitConfig() {
        System.out.println("Loading ...");
    }

    @Override
    public void process() {
        System.out.println("processing complete");
    }
}
