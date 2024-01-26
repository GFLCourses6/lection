package ua.chemerys.factory.toyota;

import ua.chemerys.factory.Vehicle;

public class JeepToyotaVehicle implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Build Toyota Jeep");
    }
}
