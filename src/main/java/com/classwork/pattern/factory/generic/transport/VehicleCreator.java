package com.classwork.pattern.factory.generic.transport;

import com.classwork.pattern.factory.generic.driver.Driver;
import com.classwork.pattern.factory.generic.driver.ManualDrive;
import com.classwork.pattern.factory.generic.navigator.GpsNavigator;
import com.classwork.pattern.factory.generic.navigator.StandAloneGpsNavigator;

public class VehicleCreator<T> {

    private final Driver<T> driver = new ManualDrive<>();

    private final GpsNavigator<T> navigator = new StandAloneGpsNavigator<>();

    public Transport<T> create(String vehicleType) {
        return createVehicle(vehicleType);
    }

    private Transport<T> createVehicle(String type) {
        return switch (type) {
            case "Plane" -> new Plane<>(driver, navigator);
            case "Ship" -> new Ship<>(driver, navigator);
            case "Motorcycle" -> new MotorCycle<>(driver, navigator);
            default -> throw new UnSupportException("Invalid vehicle type");
        };
    }
}
