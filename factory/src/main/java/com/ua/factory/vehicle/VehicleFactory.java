package com.ua.factory.vehicle;

public interface VehicleFactory {
    Vehicle createBus();

    Vehicle createTruck();

    Vehicle createCar();
}
