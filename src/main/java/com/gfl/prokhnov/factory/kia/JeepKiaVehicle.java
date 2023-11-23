package com.gfl.prokhnov.factory.kia;

import com.gfl.prokhnov.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.factory.services.updates.GpsSystems;

public class JeepKiaVehicle extends KiaVehicle {

    public JeepKiaVehicle() {
        super("JEEP",
                new AudioSystems("StandartAudio"),
                new ClimateControlSystems("StandartClimateControle"),
                new GpsSystems("StandartGpsSystem"));
    }
}
