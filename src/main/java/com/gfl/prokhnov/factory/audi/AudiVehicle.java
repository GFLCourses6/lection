package com.gfl.prokhnov.factory.audi;

import com.gfl.prokhnov.factory.AbstractVehicle;
import com.gfl.prokhnov.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.factory.services.updates.GpsSystems;

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
