package com.gfl.prokhnov.example.patterns.factory.services;

import com.gfl.prokhnov.example.patterns.factory.AbstractVehicle;
import com.gfl.prokhnov.example.patterns.factory.Vehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.Systems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;

public class ClimateControlService implements Service{

    @Override
    public void update(Vehicle vehicle, Systems systems) {
        if (vehicle instanceof AbstractVehicle abstractVehicle){
            if (systems instanceof ClimateControlSystems climateControlSystems){
                abstractVehicle.setClimateControlSystem(climateControlSystems);
            } else {
                System.out.println("This system unsupported in ClimateControlService");
            }
        } else {
            System.out.println("This vehicle unsupported in ClimateControlService");
        }
    }
}
