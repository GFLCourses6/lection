package vladproduction.com.app02.toyota;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.SUV;

public class SUVToyotaVehicle extends ToyotaAbstractVehicle {
    public SUVToyotaVehicle() {
        super(SUV, new Wheel("Michelin", 235), new GPSSystem("GPS-Toyota-suv"),
                ClimateSystem.NEW_GENERATION);
    }
}
