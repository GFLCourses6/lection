package com.vladproduction.app07;

public class MainApp07Threads {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadOne());
        thread1.start();
        Thread thread2 = new Thread(new ThreadTwo());
        thread2.start();

    }

    static class ThreadOne implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            SingletonD obj1 = SingletonD.INSTANCE;
            obj1.setUrl("111");
            System.out.println("obj1 = " + obj1);
            System.out.println("obj1.hashCode = " + obj1.hashCode());
        }
    }

    static class ThreadTwo implements Runnable{
        @Override
        public void run() {
            SingletonD obj2 = SingletonD.INSTANCE;
            obj2.setUrl("222");
            System.out.println("obj2 = " + obj2);
            System.out.println("obj2.hashCode = " + obj2.hashCode());
        }
    }
}
