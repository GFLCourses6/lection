package com.ua.factory.vehicle.kia.climate;

public class MultiZoneKiaClimateControl
        extends KiaClimateControl {

    @Override
    public void control() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Multi-Zone Kia Climate Control";
    }
}
