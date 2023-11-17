package com.ua.factory.transport.navigator;

public class StandAloneGpsNavigator<T>
        implements GpsNavigator<T> {
    @Override
    public GpsNavigator<T> create() {
        return new StandAloneGpsNavigator<>();
    }
}
