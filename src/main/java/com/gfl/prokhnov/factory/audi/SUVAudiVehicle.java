package com.gfl.prokhnov.factory.audi;

import com.gfl.prokhnov.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.factory.services.updates.GpsSystems;

public class SUVAudiVehicle extends AudiVehicle {

    public SUVAudiVehicle() {
        super("SUV",
                new AudioSystems("StandartAudio"),
                new ClimateControlSystems("StandartClimateControle"),
                new GpsSystems("StandartGpsSystem"));
    }
}
