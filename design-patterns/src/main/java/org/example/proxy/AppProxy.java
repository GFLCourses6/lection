package org.example.proxy;

public class AppProxy {
    public static void main(String[] args) {
        ExpensiveObject proxy = new ExpensiveObjectProxy();
        proxy.doSomething();
    }
}
