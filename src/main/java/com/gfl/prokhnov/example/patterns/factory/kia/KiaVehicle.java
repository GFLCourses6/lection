package com.gfl.prokhnov.example.patterns.factory.kia;

import com.gfl.prokhnov.example.patterns.factory.AbstractVehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public class KiaVehicle extends AbstractVehicle {
    public KiaVehicle(String type,
                      AudioSystems audioSystem,
                      ClimateControlSystems climateControlSystem,
                      GpsSystems gpsSystem) {
        super("KIA",
                type,
                audioSystem,
                climateControlSystem,
                gpsSystem);
    }
}
