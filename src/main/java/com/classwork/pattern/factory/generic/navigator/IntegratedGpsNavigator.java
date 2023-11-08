package com.classwork.pattern.factory.generic.navigator;

public class IntegratedGpsNavigator<T>
        implements GpsNavigator<T> {
    @Override
    public GpsNavigator<T> create() {
        return new IntegratedGpsNavigator<>();
    }
}
