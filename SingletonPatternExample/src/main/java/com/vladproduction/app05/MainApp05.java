package com.vladproduction.app05;

public class MainApp05 {
    public static void main(String[] args) {

//        SingletonC obj1 = SingletonC.getInstance("AAA");
//        System.out.println(obj1.getValue());
//
//        SingletonC obj2 = SingletonC.getInstance("BBB");
//        System.out.println(obj2.getValue());

        Thread threadOne = new Thread(new ThreadA());
        Thread threadTwo = new Thread(new ThreadB());
        threadOne.start();
        threadTwo.start();

    }
    static class ThreadA implements Runnable{
        @Override
        public void run() {
            System.out.println("ThreadA started:");
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            SingletonC obj1 = SingletonC.getInstance("AAA");
            System.out.println(obj1.getValue());
            System.out.println("hasCode.obj1 = " + obj1.hashCode());
        }
    }

    static class ThreadB implements Runnable{
        @Override
        public void run() {
            System.out.println("ThreadB started:");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            SingletonC obj2 = SingletonC.getInstance("BBB");
            System.out.println(obj2.getValue());
            System.out.println("hasCode.obj2 = " + obj2.hashCode());
        }
    }
}
