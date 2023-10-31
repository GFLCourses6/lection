package com.vladproduction.app01;

public class MainApp {
    public static void main(String[] args) {

        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();

        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());

        boolean b = obj1==obj2;
        System.out.println("b = " + b);

        boolean e = obj1.equals(obj2);
        System.out.println("e = " + e);
    }
}
