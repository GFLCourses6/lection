package vladproduction.com.app02.subaru;

import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleFactory;

public class SubaruFactory implements VehicleFactory {
    @Override
    public Vehicle createMini() {
        return new MiniSubaruVehicle();
    }

    @Override
    public Vehicle createJeep() {
        return new JeepSubaruVehicle();
    }

    @Override
    public Vehicle createSUV() {
        return new SUVSubaruVehicle();
    }
}
