package com.vladproduction.app04;

public class MainApp04 {
    public static void main(String[] args) {

        SingletonB obj1 = SingletonB.getInstance("test");
        System.out.println(obj1.getValue());

        SingletonB obj2 = SingletonB.getInstance("test2");
        System.out.println(obj2.getValue());
    }
}
