package vladproduction.com.app02.kia;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.SUV;

public class SUVKiaVehicle extends KiaAbstractVehicle {

    public SUVKiaVehicle() {
        super(SUV, new Wheel("Pirelli", 235), new GPSSystem("GPS-Kia-suv"),
                ClimateSystem.NEW_GENERATION);
    }
}
