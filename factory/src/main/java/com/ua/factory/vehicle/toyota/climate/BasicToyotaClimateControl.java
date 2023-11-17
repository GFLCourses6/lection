package com.ua.factory.vehicle.toyota.climate;

import com.ua.factory.vehicle.climate.ClimateControl;

public class BasicToyotaClimateControl
        extends ToyotaClimateControl {

    ClimateControl climateControl;

    @Override
    public void control() {
        System.out.println(climateControl);
    }

    @Override
    public String toString() {
        return "Basic Toyota ClimateControl";
    }
}
