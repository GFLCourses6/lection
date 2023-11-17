package com.ua.factory.transport.navigator;

public class IntegratedGpsNavigator<T>
        implements GpsNavigator<T> {
    @Override
    public GpsNavigator<T> create() {
        return new IntegratedGpsNavigator<>();
    }
}
