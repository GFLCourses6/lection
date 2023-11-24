package com.gfl.facade;

public class AppFacade {

    public static void main(String[] args) {
        CarEngineFacade carEngineFacade = new CarEngineFacade();
        System.out.println("        ### Starting the engine");
        carEngineFacade.startEngine();

        System.out.println("        ### Stopping the engine");
        carEngineFacade.stopEngine();
    }
}
