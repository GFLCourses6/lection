package com.classwork.pattern.factory;

public class VehicleBuildFactory {
    private final Vehicle car;
    private final Vehicle truck;
    private final Vehicle bus;

    public VehicleBuildFactory(VehicleFactory vehicleFactory) {
        this.car = vehicleFactory.createCar();
        this.bus = vehicleFactory.createBus();
        this.truck = vehicleFactory.createTruck();
    }

    public Vehicle buildCar() {
        car.create();
        return car;
    }

    public Vehicle buildBus() {
        bus.create();
        return bus;
    }

    public Vehicle buildTruck() {
        truck.create();
        return truck;
    }
}
