package com.ua.factory.vehicle.kia.creator;

import com.ua.factory.vehicle.kia.audio.KiaAudioSystem;
import com.ua.factory.vehicle.kia.climate.KiaClimateControl;

public class KiaTruck extends Kia {

    protected KiaTruck(
            KiaAudioSystem kiaAudioSystem,
            KiaClimateControl kiaClimateControl) {
        super(kiaAudioSystem,
              kiaClimateControl);
    }

    @Override
    public void create() {
        new KiaTruck(kiaAudioSystem, kiaClimateControl);
        System.out.printf(
                "Creating a Kia Truck with %s, %s%n",
                kiaAudioSystem, kiaClimateControl);
    }
}
