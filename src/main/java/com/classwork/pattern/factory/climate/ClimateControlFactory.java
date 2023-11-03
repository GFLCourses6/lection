package com.classwork.pattern.factory.climate;

public interface ClimateControlFactory {

    ClimateControl createBasic();

    ClimateControl createMultiZone();
}
