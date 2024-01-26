package ua.chemerys.factory.toyota;

import ua.chemerys.factory.*;

public class ToyotaFactory implements VehicleFactory {
    @Override
    public Vehicle buildMini() {
        return new MiniToyotaVehicle();
    }

    @Override
    public Vehicle buildJeep() {
        return new JeepToyotaVehicle();
    }

    @Override
    public Vehicle buildSUV() {
        return new SUVToyotaVehicle();
    }
}
