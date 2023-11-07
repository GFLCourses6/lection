package vladproduction.com.app02.toyota;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.JEEP;

public class JeepToyotaVehicle extends ToyotaAbstractVehicle {

    public JeepToyotaVehicle() {
        super(JEEP, new Wheel("Michelin", 205), new GPSSystem("GPS-Toyota-jeep"),
                ClimateSystem.CLIMATE_SYSTEM);
    }
}
