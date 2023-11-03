package com.classwork.pattern.factory.climate;

import com.classwork.pattern.factory.Vehicle;

public class ClimateControlBuildFactory {

    ClimateControlFacade facade;
    private final Vehicle vehicle;

    public ClimateControlBuildFactory(
            Vehicle vehicle) {
        this.vehicle = vehicle;
        this.facade = ClimateControlFacade.getInstanceClimate();
    }

    public void upgrade(){
        facade.upgrade(vehicle);
    }
}
