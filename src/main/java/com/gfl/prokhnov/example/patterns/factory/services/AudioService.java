package com.gfl.prokhnov.example.patterns.factory.services;

import com.gfl.prokhnov.example.patterns.factory.AbstractVehicle;
import com.gfl.prokhnov.example.patterns.factory.Vehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.Systems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;

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
