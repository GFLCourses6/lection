package vladproduction.com.app02.toyota;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.MINI;

public class MiniToyotaVehicle extends ToyotaAbstractVehicle {
    public MiniToyotaVehicle() {
        super(MINI, new Wheel("Michelin", 185), new GPSSystem("GPS-Toyota-mini"),
                ClimateSystem.CONDITIONER);
    }
}
