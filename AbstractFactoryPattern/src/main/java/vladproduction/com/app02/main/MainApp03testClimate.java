package vladproduction.com.app02.main;

import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.services.ClimateSystemService;

import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.*;
import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.*;
import static vladproduction.com.app02.components.ClimateSystem.*;

public class MainApp03testClimate {
    public static void main(String[] args) {



        Vehicle toyotaJeep = VehicleAbstractFactory.createVehicle(TOYOTA,JEEP);
        ClimateSystemService cs = new ClimateSystemService();
        cs.update(toyotaJeep, CLIMATE_SYSTEM_TOYOTA_JEEP);
        cs.update(toyotaJeep, CLIMATE_SYSTEM_KIA_JEEP);
        toyotaJeep.createVehicle();













    }
}
