package com.ua.factory.vehicle.climate;

import com.ua.factory.vehicle.BuildFactory;
import com.ua.factory.vehicle.Vehicle;

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
