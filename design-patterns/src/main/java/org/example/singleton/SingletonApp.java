package org.example.singleton;

public class SingletonApp {
    public static void main(String[] args) {
        // eager initialized approach:
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
        eagerInitializedSingleton.setStringValue("eagerValue");
        System.out.println(eagerInitializedSingleton.getStringValue());

        // lazy initialized approach:
        LazyInitializedSingleton lazySingleton = LazyInitializedSingleton.getInstance("lazyValue");
        System.out.println(lazySingleton.getValue());

        // thread Safe approach:
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());

        threadOne.start();
        threadTwo.start();

        // Singleton holder approach:
        Singleton singleton = Singleton.getInstance("SingletonHolder");
        System.out.println(singleton.getValue());

        // Singleton enum approach:
        SingletonEnum sg = SingletonEnum.INSTANCE;
        singleton.setValue("SingletonEnum");
           System.out.println(singleton.getValue());

    }

    static class ThreadOne implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance("value1");
            System.out.println(singleton1.getValue());
        }
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance("value2");
            System.out.println(singleton2.getValue());
        }
    }
}