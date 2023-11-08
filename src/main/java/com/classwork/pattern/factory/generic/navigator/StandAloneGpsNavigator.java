package com.classwork.pattern.factory.generic.navigator;

public class StandAloneGpsNavigator<T>
        implements GpsNavigator<T> {
    @Override
    public GpsNavigator<T> create() {
        return new StandAloneGpsNavigator<>();
    }
}
