package org.example.factory.bmw;

import org.example.factory.*;

public class BMWFactory implements VehicleFactory {
    private final Manufacturer manufacturer = Manufacturer.BMW;
    @Override
    public Vehicle buildMini() {
        return new MiniBMWVehicle(manufacturer);
    }
    @Override
    public Vehicle buildSUV() {
        return new SUVBMWVehicle(manufacturer);
    }
    @Override
    public Vehicle buildJeep() {
        return new JeepBMWVehicle(manufacturer);
    }
}
