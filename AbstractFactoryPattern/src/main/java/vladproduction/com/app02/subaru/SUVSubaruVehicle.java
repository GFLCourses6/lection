package vladproduction.com.app02.subaru;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.SUV;

public class SUVSubaruVehicle extends SubaruAbstractVehicle {
    public SUVSubaruVehicle() {
        super(SUV, new Wheel("BrainStorm", 235), new GPSSystem("GPS-Subaru-suv"),
                ClimateSystem.NEW_GENERATION);
    }
}
