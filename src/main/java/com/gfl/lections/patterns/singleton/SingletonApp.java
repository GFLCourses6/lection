package com.gfl.lections.patterns.singleton;

public class SingletonApp {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());

        threadOne.start();
        threadTwo.start();
    }

    static class ThreadOne implements Runnable {

        @Override
        public void run() {
            Singleton singleton1 = Singleton.getInstance("value1");
            System.out.println(singleton1.getValue());
        }
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            Singleton singleton2 = Singleton.getInstance("value2");
            System.out.println(singleton2.getValue());
        }
    }
}
