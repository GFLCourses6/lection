package com.gfl.prokhnov.example.patterns.factory.kia;

import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public class JeepKiaVehicle extends KiaVehicle {

    public JeepKiaVehicle() {
        super("JEEP",
                new AudioSystems("StandartAudio"),
                new ClimateControlSystems("StandartClimateControle"),
                new GpsSystems("StandartGpsSystem"));
    }
}
