package com.gfl.prokhnov.factory.audi;

import com.gfl.prokhnov.factory.Vehicle;
import com.gfl.prokhnov.factory.VehicleFactory;

public class AudiFactory implements VehicleFactory {
    @Override
    public Vehicle buildMini() {
        return new MiniAudiVehicle();
    }

    @Override
    public Vehicle buildSUV() {
        return new SUVAudiVehicle();
    }

    @Override
    public Vehicle buildJeep() {
        return new JeepAudiVehicle();
    }
}
