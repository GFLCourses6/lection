package com.gfl.prokhnov.factory.services;

import com.gfl.prokhnov.factory.AbstractVehicle;
import com.gfl.prokhnov.factory.Vehicle;
import com.gfl.prokhnov.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.factory.services.updates.Systems;

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
