package org.example.factory.rangerover;

import org.example.factory.*;

public class RangeRoverFactory implements VehicleFactory {
    private final Manufacturer manufacturer = Manufacturer.RANGE_ROVER;
    @Override
    public Vehicle buildMini() {
        return new MiniRangeRoverVehicle(manufacturer);
    }

    @Override
    public Vehicle buildSUV() {
        return new SUVRangeRoverVehicle(manufacturer);
    }

    @Override
    public Vehicle buildJeep() {
        return new JeepRangeRoverVehicle(manufacturer);
    }
}
