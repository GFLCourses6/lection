package com.ua.factory.vehicle.climate;

public interface ClimateControlFactory {

    ClimateControl createBasic();

    ClimateControl createMultiZone();
}
