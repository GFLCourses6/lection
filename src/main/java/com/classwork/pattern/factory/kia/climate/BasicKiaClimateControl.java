package com.classwork.pattern.factory.kia.climate;

public class BasicKiaClimateControl
        extends KiaClimateControl {

    @Override
    public void control() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Basic Kia ClimateControl";
    }
}
