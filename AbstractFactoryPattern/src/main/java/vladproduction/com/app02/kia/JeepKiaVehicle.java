package vladproduction.com.app02.kia;



import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.JEEP;

public class JeepKiaVehicle extends KiaAbstractVehicle {
    public JeepKiaVehicle() {
        super(JEEP, new Wheel("Pirelli", 205), new GPSSystem("GPS-Kia-jeep"),
                ClimateSystem.CLIMATE_SYSTEM);
    }
}
