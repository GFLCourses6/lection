package com.gfl.prokhnov.factory.toyota;

import com.gfl.prokhnov.factory.AbstractVehicle;
import com.gfl.prokhnov.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.factory.services.updates.GpsSystems;

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
