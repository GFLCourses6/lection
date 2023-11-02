package com.gfl.singleton;

public class Main {
    public static void main(String[] args) {
        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new ThreadTwo());

        one.start();
        two.start();
    }

    static class ThreadTwo
            implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Runnable");
            System.out.println(singleton);
        }
    }

    static class ThreadOne
            implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Thread");
            System.out.println(singleton);
        }
    }
}
