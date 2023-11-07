package vladproduction.com.app02.services;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.components.GPSSystem;

public class GPSSystemService {

    public void update(Vehicle vehicle, GPSSystem updatedGPS){
        if(vehicle instanceof AbstractVehicle){
            AbstractVehicle av = (AbstractVehicle) vehicle;
            av.setGpsSystem(updatedGPS);
            System.out.println("GPSSystem updated successfully");
        }else {
            System.out.println("cannot update GPSSystem for this Vehicle");
        }
    }
}
