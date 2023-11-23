package com.gfl.prokhnov.factory.kia;

import com.gfl.prokhnov.factory.AbstractVehicle;
import com.gfl.prokhnov.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.factory.services.updates.GpsSystems;

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
