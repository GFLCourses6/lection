package com.vladproduction.app05;

public class SingletonC2 {
    private String value;
    private static SingletonC2 instance;

    public SingletonC2(String value) {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static synchronized SingletonC2 getInstance(String value) {

            if(instance == null){
                instance = new SingletonC2(value);
            }

        return instance;


    }

}
