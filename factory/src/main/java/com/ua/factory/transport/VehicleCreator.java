package com.ua.factory.transport;

import com.ua.factory.transport.driver.Driver;
import com.ua.factory.transport.driver.ManualDrive;
import com.ua.factory.transport.model.MotorCycle;
import com.ua.factory.transport.model.Plane;
import com.ua.factory.transport.model.Ship;
import com.ua.factory.transport.model.Transport;
import com.ua.factory.transport.model.UnSupportException;
import com.ua.factory.transport.navigator.GpsNavigator;
import com.ua.factory.transport.navigator.StandAloneGpsNavigator;

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
