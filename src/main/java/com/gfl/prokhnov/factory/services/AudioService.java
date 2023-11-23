package com.gfl.prokhnov.factory.services;

import com.gfl.prokhnov.factory.AbstractVehicle;
import com.gfl.prokhnov.factory.Vehicle;
import com.gfl.prokhnov.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.factory.services.updates.Systems;

public class AudioService implements Service{

    @Override
    public void update(Vehicle vehicle, Systems systems) {
        if (vehicle instanceof AbstractVehicle abstractVehicle){
            if (systems instanceof AudioSystems audioSystem){
                abstractVehicle.setAudioSystem(audioSystem);
            } else {
                System.out.println("This system unsupported in AudioService");
            }
        } else {
            System.out.println("This vehicle unsupported in AudioService");
        }
    }
}
