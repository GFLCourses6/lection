package com.classwork.pattern.factory.generic.navigator;

public interface GpsNavigator<T> {
    GpsNavigator<T> create();
}
