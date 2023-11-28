package org.example.proxy;

public class ExpensiveObjectReal implements ExpensiveObject {
    public ExpensiveObjectReal() {
        heavyInitConfig();
    }

    private void heavyInitConfig() {
        System.out.println("Loading ...");
    }

    @Override
    public void doSomething() {
        System.out.println("processing complete");
    }
}
