package ua.chemerys.factory.subaru;

import ua.chemerys.factory.Vehicle;
import ua.chemerys.factory.VehicleFactory;

public class SubaruFactory implements VehicleFactory {
    @Override
    public Vehicle buildMini() {
        return null;
    }

    @Override
    public Vehicle buildJeep() {
        return null;
    }

    @Override
    public Vehicle buildSUV() {
        return null;
    }
}
