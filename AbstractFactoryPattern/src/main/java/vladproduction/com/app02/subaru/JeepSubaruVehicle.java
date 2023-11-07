package vladproduction.com.app02.subaru;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.JEEP;

public class JeepSubaruVehicle extends SubaruAbstractVehicle {

    public JeepSubaruVehicle() {
        super(JEEP, new Wheel("BrainStorm", 205), new GPSSystem("GPS-Subaru-jeep"),
                ClimateSystem.CLIMATE_SYSTEM);
    }
}
