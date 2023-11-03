package com.classwork.pattern.factory.toyota.climate;

import com.classwork.pattern.factory.climate.ClimateControl;

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
