package com.gfl.singleton;

public class AppSingleton {

    public static void main(String[] args) {
        AppSingleton app = new AppSingleton();
        app.run();
    }

    private void run() {
        // classes:
        Runnable runnable1 = () -> {
            Singleton singleton = Singleton.getInstance("v1");
            singleton.printValue();
        };
        Runnable runnable2 = () -> {
            Singleton singleton = Singleton.getInstance("v2");
            singleton.printValue();
        };

        startParallelExecution(runnable1, runnable2);

        // alt. enum approach:
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.setValue("v3");
        singleton.printValue();
    }

    private void startParallelExecution(Runnable r1, Runnable r2) {
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
