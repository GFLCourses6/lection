package ua.chemerys.factory.kia;

import ua.chemerys.factory.Vehicle;

public class MiniKiaVehicle implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Build Kia Mini");
    }
}
