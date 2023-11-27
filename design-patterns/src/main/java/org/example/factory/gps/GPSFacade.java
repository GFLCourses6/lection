package org.example.factory.gps;

import org.example.factory.Manufacturer;
import org.example.factory.Vehicle;
import org.example.factory.bmw.gps.BMWGPS;
import org.example.factory.bmw.gps.GPSBMWCreator;
import org.example.factory.rangerover.gps.GPSRangeRoverCreator;
import org.example.factory.rangerover.gps.RangeRoverGPS;

public class GPSFacade {

    private final GPSRangeRoverCreator rangeRoverCreator;

    private final GPSBMWCreator bmwCreator;

    public GPSFacade(GPSRangeRoverCreator rangeRoverCreator, GPSBMWCreator bmwCreator) {
        this.rangeRoverCreator = rangeRoverCreator;
        this.bmwCreator = bmwCreator;
    }

    public GPSFacade() {
        this.bmwCreator = new GPSBMWCreator();
        this.rangeRoverCreator = new GPSRangeRoverCreator();
    }

    private static final class GPSFacadeHolder{
        private static final GPSFacade INSTANCE = new GPSFacade();
    }

    public static GPSFacade getInstance(){
        return GPSFacadeHolder.INSTANCE;
    }

    public void upgradeHighEnd(Vehicle vehicle){
        if(vehicle.getManufacturer().equals(Manufacturer.RANGE_ROVER)){
            vehicle.upgradeGPS(getRangeRoverHighEndGGPS());
        } else if(vehicle.getManufacturer().equals(Manufacturer.BMW)){
            vehicle.upgradeGPS(getBMWHIghEndGPS());
        }
    }

    public void upgradeLowEnd(Vehicle vehicle){
        if(vehicle.getManufacturer().equals(Manufacturer.RANGE_ROVER)){
            vehicle.upgradeGPS(getRangeRoverLowEndGGPS());
        } else if(vehicle.getManufacturer().equals(Manufacturer.BMW)){
            vehicle.upgradeGPS(getBMWLowEndGPS());
        }
    }


    private RangeRoverGPS getRangeRoverHighEndGGPS(){
        return rangeRoverCreator.createHighEndGpsSystem();
    }

    private RangeRoverGPS getRangeRoverLowEndGGPS(){
        return rangeRoverCreator.createLowEndGpsSystem();
    }

    private BMWGPS getBMWHIghEndGPS(){
        return bmwCreator.createHighEndGpsSystem();
    }

    private BMWGPS getBMWLowEndGPS(){
        return bmwCreator.createLowEndGpsSystem();
    }
}
