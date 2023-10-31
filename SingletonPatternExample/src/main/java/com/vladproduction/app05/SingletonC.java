package com.vladproduction.app05;

public class SingletonC {
    private String value;
    private static SingletonC instance;

    public SingletonC(String value) {
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

    public static SingletonC getInstance(String value) {
        //synchronized (SingletonC.class){
            if(instance == null){
                instance = new SingletonC(value);
            }
        //}
        return instance;


    }

}
