package com.classwork.pattern.factory;

public interface VehicleFactory {
    Vehicle createBus();

    Vehicle createTruck();

    Vehicle createCar();
}
