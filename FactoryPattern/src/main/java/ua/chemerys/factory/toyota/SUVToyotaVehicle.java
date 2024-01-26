package ua.chemerys.factory.toyota;

import ua.chemerys.factory.Vehicle;

public class SUVToyotaVehicle implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Build Toyota SUV");
    }
}
