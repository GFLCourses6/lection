package com.gfl.prokhnov.facade;

public class FacadeApp {
    public static void main(String[] args) {
        FacadeApp facadeApp = new FacadeApp();
        facadeApp.run();
    }

    private void run() {
        Facade facade = new Facade();
        facade.callSingletons();
    }
}
