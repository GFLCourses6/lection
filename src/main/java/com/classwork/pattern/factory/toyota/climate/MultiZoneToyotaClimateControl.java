package com.classwork.pattern.factory.toyota.climate;

public class MultiZoneToyotaClimateControl
        extends ToyotaClimateControl {
    @Override
    public void control() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Multi-Zone Toyota Climate Control";
    }
}
