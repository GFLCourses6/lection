package ua.chemerys.factory.kia;

import ua.chemerys.factory.Vehicle;

public class JeepKiaVehicle implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Build Kia Jeep");
    }
}
