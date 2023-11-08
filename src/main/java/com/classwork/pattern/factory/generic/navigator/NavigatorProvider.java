package com.classwork.pattern.factory.generic.navigator;

public class NavigatorProvider<T> {

    GpsNavigator<T> integrated;
    GpsNavigator<T> standAlone;

    public NavigatorProvider() {
        this.integrated = new IntegratedGpsNavigator<>();
        this.standAlone = new StandAloneGpsNavigator<>();
    }
}
