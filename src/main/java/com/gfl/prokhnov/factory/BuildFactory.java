package com.gfl.prokhnov.factory;

public class BuildFactory {

    private final Vehicle mini;
    private final Vehicle suv;
    private final Vehicle jeep;

    public BuildFactory(VehicleFactory vehicleFactory) {
        this.jeep = vehicleFactory.buildJeep();
        this.mini = vehicleFactory.buildMini();
        this.suv = vehicleFactory.buildSUV();
    }

    public Vehicle buildMini() {
        mini.createVehicle();
        return mini;
    }

    public Vehicle buildSUV() {
        suv.createVehicle();
        return suv;
    }

    public Vehicle buildJeep() {
        jeep.createVehicle();
        return jeep;
    }
}
