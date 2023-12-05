package com.gfl.prokhnov.example.patterns.factory.toyota;

import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public class SUVToyotaVehicle extends ToyotaVehicle {
    public SUVToyotaVehicle() {
        super("SUV",
                new AudioSystems("StandartAudio"),
                new ClimateControlSystems("StandartClimateControle"),
                new GpsSystems("StandartGpsSystem"));
    }
}
