package vladproduction.com.app02.subaru;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.*;

public abstract class SubaruAbstractVehicle extends AbstractVehicle {
    public SubaruAbstractVehicle(VehicleAbstractFactory.VehicleType vehicleType,
                                 Wheel wheel, GPSSystem gpsSystem, ClimateSystem climateSystem) {
        super(vehicleType, SUBARU, wheel, gpsSystem, climateSystem);
    }
}
