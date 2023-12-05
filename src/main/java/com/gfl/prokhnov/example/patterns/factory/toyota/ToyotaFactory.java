package com.gfl.prokhnov.example.patterns.factory.toyota;

import com.gfl.prokhnov.example.patterns.factory.Vehicle;
import com.gfl.prokhnov.example.patterns.factory.VehicleFactory;

public class ToyotaFactory implements VehicleFactory {
    @Override
    public Vehicle buildMini() {
        return new MiniToyotaVehicle();
    }

    @Override
    public Vehicle buildSUV() {
        return new SUVToyotaVehicle();
    }

    @Override
    public Vehicle buildJeep() {
        return new JeepToyotaVehicle();
    }
}
