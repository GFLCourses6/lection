package com.vladproduction.app06;

public class MainApp06 {
    public static void main(String[] args) {

        SingletonClassNotLazy obj = SingletonClassNotLazy.getInstance();
        System.out.println(obj);
    }
}
