package vladproduction.com.app02.services;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.VehicleAbstractFactory;
import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.kia.JeepKiaVehicle;
import vladproduction.com.app02.kia.MiniKiaVehicle;
import vladproduction.com.app02.kia.SUVKiaVehicle;
import vladproduction.com.app02.subaru.JeepSubaruVehicle;
import vladproduction.com.app02.subaru.MiniSubaruVehicle;
import vladproduction.com.app02.subaru.SUVSubaruVehicle;
import vladproduction.com.app02.toyota.JeepToyotaVehicle;
import vladproduction.com.app02.toyota.MiniToyotaVehicle;
import vladproduction.com.app02.toyota.SUVToyotaVehicle;

public class ClimateSystemService {


    public void update(Vehicle vehicle, ClimateSystem updatedClimate){

        if(vehicle instanceof AbstractVehicle av){

            VehicleAbstractFactory.ManufactureType climateManufactureType = updatedClimate.getManufactureType();
            VehicleAbstractFactory.VehicleType climateVehicleType = updatedClimate.getVehicleType();

            VehicleAbstractFactory.ManufactureType avManufactureType = av.getManufactureType();
            VehicleAbstractFactory.VehicleType avVehicleType = av.getVehicleType();

            if(!climateManufactureType.equals(avManufactureType)){
                System.out.println("cannot update Climate System for this Vehicle");
                return;
            }

            if(!climateVehicleType.equals(avVehicleType)){
                System.out.println("cannot update Climate System for this Vehicle");
                return;
            }
            av.setClimateSystem(updatedClimate);
            System.out.println("ClimateSystem updated successfully");


        }else {
            System.out.println("cannot update Climate System for this Vehicle");
        }
    }



}
