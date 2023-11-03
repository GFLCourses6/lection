package com.classwork.pattern.factory.kia.creator;

import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.kia.climate.KiaClimateControl;

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
