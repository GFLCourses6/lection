package vladproduction.com.app02.kia;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.KIA;

public abstract class KiaAbstractVehicle extends AbstractVehicle {
    public KiaAbstractVehicle(VehicleAbstractFactory.VehicleType vehicleType,
                              Wheel wheel, GPSSystem gpsSystem, ClimateSystem climateSystem) {
        super(vehicleType, KIA, wheel, gpsSystem, climateSystem);
    }

}
