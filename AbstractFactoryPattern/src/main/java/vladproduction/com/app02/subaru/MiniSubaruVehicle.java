package vladproduction.com.app02.subaru;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.MINI;

public class MiniSubaruVehicle extends SubaruAbstractVehicle {
    public MiniSubaruVehicle() {
        super(MINI, new Wheel("BrainStorm", 185), new GPSSystem("GPS-Subaru-mini"),
                ClimateSystem.CONDITIONER);
    }
}
