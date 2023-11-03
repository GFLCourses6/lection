package com.classwork.pattern.factory.creator.bmw;

public abstract class Bmw {
    BmwAutoDriver driver;
    BmwGpsNavigator navigator;

    protected Bmw(
            final BmwAutoDriver driver,
            final BmwGpsNavigator navigator) {
        this.driver = driver;
        this.navigator = navigator;
    }

    public void upgradeDriver(
            final BmwAutoDriver audioSystem) {
        this.driver = audioSystem;
    }

    public void upgradeNavigator(
            final BmwGpsNavigator climateControl) {
        this.navigator = climateControl;
    }
}
