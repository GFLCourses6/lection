package ua.chemerys.factory.kia;

import ua.chemerys.factory.*;

public class KiaFactory implements VehicleFactory {
    @Override
    public Vehicle buildMini() {
        return new MiniKiaVehicle();
    }

    @Override
    public Vehicle buildJeep() {
        return new JeepKiaVehicle();
    }

    @Override
    public Vehicle buildSUV() {
        return new SUVKiaVehicle();
    }
}
