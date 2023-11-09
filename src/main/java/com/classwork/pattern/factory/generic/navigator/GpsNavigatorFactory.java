package com.classwork.pattern.factory.generic.navigator;

public class GpsNavigatorFactory<T> {

    GpsNavigator<T> integrated;
    GpsNavigator<T> standAlone;

    public GpsNavigator<T> create(String type) {
        return "Integrated".equalsIgnoreCase(type)
               ? integrated
               : standAlone;
    }

    public GpsNavigatorFactory() {
        this.integrated = new IntegratedGpsNavigator<>();
        this.standAlone = new StandAloneGpsNavigator<>();
    }
}
