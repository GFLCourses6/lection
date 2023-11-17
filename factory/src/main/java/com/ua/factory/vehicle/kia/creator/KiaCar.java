package com.ua.factory.vehicle.kia.creator;

import com.ua.factory.vehicle.kia.audio.KiaAudioSystem;
import com.ua.factory.vehicle.kia.climate.KiaClimateControl;

public class KiaCar extends Kia {

    protected KiaCar(
            KiaAudioSystem kiaAudioSystem,
            KiaClimateControl kiaClimateControl) {
        super(kiaAudioSystem,
              kiaClimateControl);
    }

    @Override
    public void create() {
        new KiaCar(kiaAudioSystem, kiaClimateControl);
        System.out.printf(
                "Creating a Kia Car with %s, %s%n",
                kiaAudioSystem, kiaClimateControl);
    }
}
