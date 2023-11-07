package vladproduction.com.app02.kia;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.MINI;

public class MiniKiaVehicle extends KiaAbstractVehicle {

    public MiniKiaVehicle() {
        super(MINI, new Wheel("Pirelli", 185), new GPSSystem("GPS-Kia-mini"),
                ClimateSystem.CONDITIONER);
    }
}
