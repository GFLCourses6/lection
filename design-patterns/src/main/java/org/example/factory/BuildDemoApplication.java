package org.example.factory;

import org.example.factory.bmw.BMWFactory;
import org.example.factory.gps.GPSBuildFactory;
import org.example.factory.music.MusicSystemBuildFactory;
import org.example.factory.rangerover.RangeRoverFactory;

public class BuildDemoApplication {
    public static void main(String[] args) {
        VehicleFactory bmwFactory = new BMWFactory();
        VehicleBuildFactory buildBMWFactory = new VehicleBuildFactory(bmwFactory); // abstract factory

        VehicleFactory rangeRoverFactory = new RangeRoverFactory();
        VehicleBuildFactory buildRangeRoverFactory = new VehicleBuildFactory(rangeRoverFactory);

        Vehicle suvByBMW = buildBMWFactory.buildSUV();

        Vehicle jeepByRangeRover = buildRangeRoverFactory.buildJepp();
        // у нас есть одна абстрактная фабрика, которой мы передаем нашу фабрику, с которой нам нужно выдернуть
        // тот или иной элемент.
        // псле этого мы сможем билдить тот или иной объект

        Vehicle jeepByBMW = buildBMWFactory.buildJepp();
        System.out.println("MUSIC: ");
        MusicSystemBuildFactory musicSystemBuildFactory1 = new MusicSystemBuildFactory(jeepByBMW);
        musicSystemBuildFactory1.upgradeWhipLowEnd();
        musicSystemBuildFactory1.upgradeWhipHighEnd();
        MusicSystemBuildFactory musicSystemBuildFactory2 = new MusicSystemBuildFactory(jeepByRangeRover);
        musicSystemBuildFactory2.upgradeWhipLowEnd();
        musicSystemBuildFactory2.upgradeWhipHighEnd();

        System.out.println("GPS: ");
        GPSBuildFactory gpsBuildFactory1 = new GPSBuildFactory(jeepByBMW);
        gpsBuildFactory1.upgradeWhipLowEnd();
        gpsBuildFactory1.upgradeWhipHighEnd();
        GPSBuildFactory gpsBuildFactory2 = new GPSBuildFactory(jeepByRangeRover);
        gpsBuildFactory2.upgradeWhipHighEnd();
        gpsBuildFactory2.upgradeWhipLowEnd();
    }

}
