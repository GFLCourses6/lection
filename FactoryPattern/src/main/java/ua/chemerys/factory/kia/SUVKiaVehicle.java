package ua.chemerys.factory.kia;

import ua.chemerys.factory.Vehicle;

public class SUVKiaVehicle implements Vehicle {
    @Override
    public void createVehicle() {
        System.out.println("Build Kia SUV");
    }
}
