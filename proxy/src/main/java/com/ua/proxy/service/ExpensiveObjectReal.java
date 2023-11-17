package com.ua.proxy.service;

public class ExpensiveObjectReal
        implements ExpensiveObject {
    public ExpensiveObjectReal() {
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
