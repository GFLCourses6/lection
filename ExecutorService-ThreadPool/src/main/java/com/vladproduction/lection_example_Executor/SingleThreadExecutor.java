package com.vladproduction.lection_example_Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> System.out.println("Hello; " + Thread.currentThread().getName()));
        executor.execute(()-> System.out.println("Hello World; " + Thread.currentThread().getName()));
        System.out.println("MAIN; " + Thread.currentThread().getName());
    }
}
