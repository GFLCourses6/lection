package com.gfl.facade.service;

public class CoolingController {

    private int temperatureUpperLimit = 0;

    public int getTemperatureUpperLimit() {
        return temperatureUpperLimit;
    }

    public void setTemperatureUpperLimit(int temperatureUpperLimit) {
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    public void run() {
        System.out.println("Cooling controller is running");
    }

    public void cool(int maxAllowedTemp) {
        System.out.println("Cooling by " + maxAllowedTemp);
    }

    public void stop() {
        System.out.println("Stopping the cooling controller");
    }
}
