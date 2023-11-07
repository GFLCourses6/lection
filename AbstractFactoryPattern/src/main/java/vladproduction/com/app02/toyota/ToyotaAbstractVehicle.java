package vladproduction.com.app02.toyota;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.TOYOTA;

public abstract class ToyotaAbstractVehicle extends AbstractVehicle {
    public ToyotaAbstractVehicle(VehicleAbstractFactory.VehicleType vehicleType,
                                 Wheel wheel, GPSSystem gpsSystem, ClimateSystem climateSystem) {
        super(vehicleType, TOYOTA, wheel, gpsSystem, climateSystem);
    }
}
