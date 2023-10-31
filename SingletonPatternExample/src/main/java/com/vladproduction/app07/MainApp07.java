package com.vladproduction.app07;

public class MainApp07 {
    public static void main(String[] args) {

        SingletonD singletonDFirst = SingletonD.INSTANCE;
        singletonDFirst.setUrl("url098");

        SingletonD singletonDSecond = SingletonD.INSTANCE;
        singletonDSecond.setUrl("url099");

        System.out.println(singletonDFirst.getUrl());
        System.out.println(singletonDSecond.getUrl());

        System.out.println(singletonDFirst.hashCode());
        System.out.println(singletonDSecond.hashCode());

    }
}
