package com.vladproduction.app02;

public class Database {
    private double url;
    private static Database instance;

    public Database(){
        if(instance != null){
            throw new RuntimeException("instance already created: " + instance.url);
        }else {
            this.url = Math.random();
            instance = this;
            System.out.println("instance created: " + instance.url);
        }
    }

    @Override
    public String toString() {
        return "" + url;
    }
}
