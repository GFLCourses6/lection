package com.gfl.prokhnov.example.patterns.factory.audi;

import com.gfl.prokhnov.example.patterns.factory.AbstractVehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public class AudiVehicle extends AbstractVehicle {
    public AudiVehicle(String type,
                       AudioSystems audioSystem,
                       ClimateControlSystems climateControlSystem,
                       GpsSystems gpsSystem) {
        super("AUDI",
                type,
                audioSystem,
                climateControlSystem,
                gpsSystem);
    }
}
