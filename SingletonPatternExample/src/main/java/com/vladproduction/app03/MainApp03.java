package com.vladproduction.app03;

import java.util.Timer;

public class MainApp03 {
    public static void main(String[] args) {

        SingletonA obj1 = SingletonA.getInstance();
        SingletonA obj2 = SingletonA.getInstance();
        System.out.println(obj1==obj2);
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj1.equals(obj2));
    }
}
