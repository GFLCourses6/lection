package vladproduction.com.app02.main;

import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.services.ClimateSystemService;
import vladproduction.com.app02.services.GPSSystemService;
import vladproduction.com.app02.services.WheelService;
import vladproduction.com.app02.components.Wheel;

import static vladproduction.com.app02.VehicleAbstractFactory.ManufactureType.*;
import static vladproduction.com.app02.VehicleAbstractFactory.VehicleType.*;

public class MainApp03 {
    public static void main(String[] args) {

        System.out.println("========Kia=============");
        Vehicle kiaMini = VehicleAbstractFactory.createVehicle(KIA,MINI);
        Vehicle kiaJeep = VehicleAbstractFactory.createVehicle(KIA,JEEP);
        Vehicle kiaSuv = VehicleAbstractFactory.createVehicle(KIA,SUV);
        kiaMini.createVehicle();
        System.out.println("------------");
        kiaJeep.createVehicle();
        System.out.println("------------");
        kiaSuv.createVehicle();
        System.out.println("------------");
        System.out.println();

        System.out.println("========Toyota=============");
        Vehicle toyotaMini = VehicleAbstractFactory.createVehicle(TOYOTA,MINI);
        Vehicle toyotaJeep = VehicleAbstractFactory.createVehicle(TOYOTA,JEEP);
        Vehicle toyotaSuv = VehicleAbstractFactory.createVehicle(TOYOTA,SUV);
        toyotaMini.createVehicle();
        System.out.println("------------");
        toyotaJeep.createVehicle();
        System.out.println("------------");
        toyotaSuv.createVehicle();
        System.out.println("------------");
        System.out.println();

        System.out.println("========Subaru=============");
        Vehicle subaruMini = VehicleAbstractFactory.createVehicle(SUBARU,MINI);
        Vehicle subaruJeep = VehicleAbstractFactory.createVehicle(SUBARU,JEEP);
        Vehicle subaruSuv = VehicleAbstractFactory.createVehicle(SUBARU,SUV);
        subaruMini.createVehicle();
        System.out.println("------------");
        subaruJeep.createVehicle();
        System.out.println("------------");
        subaruSuv.createVehicle();
        System.out.println("------------");
        System.out.println();


        System.out.println("service-wheel---->");
        WheelService wheelService = new WheelService();
        //kia change wheels:
        wheelService.update(kiaMini, new Wheel("Pirelli-2023", 195));
        kiaMini.createVehicle();
        System.out.println("------------");

        System.out.println("service-climate---->");
        ClimateSystemService cs = new ClimateSystemService();
        //toyota change climate:
        cs.update(toyotaMini, ClimateSystem.CLIMATE_SYSTEM);
        toyotaMini.createVehicle();
        System.out.println("------------");
        //subaru change climate:
        cs.update(subaruMini, ClimateSystem.CLIMATE_SYSTEM);
        subaruMini.createVehicle();
        System.out.println("------------");

        System.out.println("service-gps---->");
        GPSSystemService gpsSystemService = new GPSSystemService();
        //toyota change gps:
        gpsSystemService.update(toyotaJeep, new GPSSystem("GPS-Toyota-jeep(wifi+Android)"));
        toyotaJeep.createVehicle();








    }
}
