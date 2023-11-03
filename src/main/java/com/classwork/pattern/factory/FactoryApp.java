package com.classwork.pattern.factory;

import com.classwork.pattern.factory.audio.AudioSystemBuildFactory;
import com.classwork.pattern.factory.climate.ClimateControlBuildFactory;
import com.classwork.pattern.factory.kia.creator.KiaFactory;
import com.classwork.pattern.factory.toyota.creator.ToyotaFactory;

public class FactoryApp {
    public static void main(String[] args) {

        VehicleFactory kiaFactory = new KiaFactory();

        VehicleBuildFactory buildKiaFactory =
                new VehicleBuildFactory(kiaFactory);

        Vehicle car = buildKiaFactory.buildCar();

        AudioSystemBuildFactory audioSystemFactory =
                new AudioSystemBuildFactory(car);

        audioSystemFactory.upgrade();
        buildKiaFactory.buildTruck();
        buildKiaFactory.buildBus();

        VehicleFactory toyotaFactory =
                new ToyotaFactory();
        VehicleBuildFactory buildToyotaFactory =
                new VehicleBuildFactory(toyotaFactory);
        Vehicle truck = buildToyotaFactory.buildTruck();

        ClimateControlBuildFactory climateControlBuildFactory =
                new ClimateControlBuildFactory(truck);
        climateControlBuildFactory.upgrade();

        buildToyotaFactory.buildBus();
        buildToyotaFactory.buildCar();
    }
}
