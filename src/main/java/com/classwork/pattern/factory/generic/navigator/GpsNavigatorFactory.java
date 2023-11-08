package com.classwork.pattern.factory.generic.navigator;

public class GpsNavigatorFactory<T> {
    public GpsNavigator<T> create(String type) {
        return "Integrated".equalsIgnoreCase(type)
               ? new IntegratedGpsNavigator<>()
               : new StandAloneGpsNavigator<>();
    }
}
