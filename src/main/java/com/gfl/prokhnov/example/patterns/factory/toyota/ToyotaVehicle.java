package com.gfl.prokhnov.example.patterns.factory.toyota;

import com.gfl.prokhnov.example.patterns.factory.AbstractVehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public class ToyotaVehicle extends AbstractVehicle {
    public ToyotaVehicle(String type,
                         AudioSystems audioSystem,
                         ClimateControlSystems climateControlSystem,
                         GpsSystems gpsSystem) {
        super("TOYOTA",
                type,
                audioSystem,
                climateControlSystem,
                gpsSystem);
    }
}
