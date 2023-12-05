package com.gfl.prokhnov.example.patterns.factory.toyota;

import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public class JeepToyotaVehicle extends ToyotaVehicle {

    public JeepToyotaVehicle() {
        super( "JEEP",
                new AudioSystems("StandartAudio"),
                new ClimateControlSystems("StandartClimateControle"),
                new GpsSystems("StandartGpsSystem"));
    }
}
