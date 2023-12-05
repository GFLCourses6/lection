package com.gfl.prokhnov.example.patterns.factory.services;

import com.gfl.prokhnov.example.patterns.factory.AbstractVehicle;
import com.gfl.prokhnov.example.patterns.factory.Vehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.Systems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

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
