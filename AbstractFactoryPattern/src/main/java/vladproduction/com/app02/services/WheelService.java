package vladproduction.com.app02.services;

import vladproduction.com.app02.AbstractVehicle;
import vladproduction.com.app02.Vehicle;
import vladproduction.com.app02.components.Wheel;

public class WheelService {

    public void update(Vehicle vehicle, Wheel updatedWheel){
        if(vehicle instanceof AbstractVehicle){
            AbstractVehicle av = (AbstractVehicle) vehicle;
            av.setWheel(updatedWheel);
            System.out.println("Wheel updated successfully");
        }else {
            System.out.println("cannot update wheel for this Vehicle");
        }
    }
}
