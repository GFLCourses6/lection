package com.gfl.prokhnov.factory.kia;

import com.gfl.prokhnov.factory.Vehicle;
import com.gfl.prokhnov.factory.VehicleFactory;

public class KiaFactory implements VehicleFactory {
    @Override
    public Vehicle buildMini() {
        return new MiniKiaVehicle();
    }

    @Override
    public Vehicle buildSUV() {
        return new SUVKiaVehicle();
    }

    @Override
    public Vehicle buildJeep() {
        return new JeepKiaVehicle();
    }
}
