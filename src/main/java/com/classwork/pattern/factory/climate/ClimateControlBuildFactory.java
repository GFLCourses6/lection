package com.classwork.pattern.factory.climate;

import com.classwork.pattern.factory.BuildFactory;
import com.classwork.pattern.factory.Vehicle;

public class ClimateControlBuildFactory implements BuildFactory {

    ClimateControlFacade facade;
    private final Vehicle vehicle;

    public ClimateControlBuildFactory(
            Vehicle vehicle) {
        this.vehicle = vehicle;
        this.facade = ClimateControlFacade.getInstanceClimate();
    }

    @Override
    public void upgrade(){
        facade.upgrade(vehicle);
    }
}
