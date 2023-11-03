package com.classwork.pattern.factory.toyota.creator;

import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystem;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControl;

public class ToyotaTruck
        extends Toyota {

    public ToyotaTruck(
            ToyotaAudioSystem toyotaAudioSystem,
            ToyotaClimateControl toyotaClimateControl) {
        super(toyotaAudioSystem,
              toyotaClimateControl);
    }

    @Override
    public void create() {
        new ToyotaTruck(toyotaAudioSystem, toyotaClimateControl);
        System.out.printf(
                "Creating a Toyota Truck with %s, %s%n",
                toyotaAudioSystem,
                toyotaClimateControl);
    }
}
