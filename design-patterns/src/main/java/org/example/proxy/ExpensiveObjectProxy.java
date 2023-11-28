package org.example.proxy;

public class ExpensiveObjectProxy implements ExpensiveObject {
    private ExpensiveObject object;
    @Override
    public void doSomething() {
        if (object == null) {
            System.out.println("proxy!");
            object = new ExpensiveObjectReal();
        }
        object.doSomething();
    }
}
