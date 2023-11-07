package vladproduction.com.app02.toyota;

import vladproduction.com.app02.*;

public class ToyotaFactory implements VehicleFactory {
    @Override
    public Vehicle createMini() {
        return new MiniToyotaVehicle();
    }

    @Override
    public Vehicle createJeep() {
        return new JeepToyotaVehicle();
    }

    @Override
    public Vehicle createSUV() {
        return new SUVToyotaVehicle();
    }
}
