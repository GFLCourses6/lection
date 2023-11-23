package com.gfl.prokhnov.factory.services;

import com.gfl.prokhnov.factory.AbstractVehicle;
import com.gfl.prokhnov.factory.Vehicle;
import com.gfl.prokhnov.factory.services.updates.GpsSystems;
import com.gfl.prokhnov.factory.services.updates.Systems;

public class GpsSystemService implements Service{

    @Override
    public void update(Vehicle vehicle, Systems systems) {
        if (vehicle instanceof AbstractVehicle abstractVehicle){
            if (systems instanceof GpsSystems gpsSystems){
                abstractVehicle.setGpsSystem(gpsSystems);
            } else {
                System.out.println("This system unsupported in GpsSystemService");
            }
        } else {
            System.out.println("This vehicle unsupported in GpsSystemService");
        }
    }
}
