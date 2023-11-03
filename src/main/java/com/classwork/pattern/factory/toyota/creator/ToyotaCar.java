package com.classwork.pattern.factory.toyota.creator;

import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystem;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControl;

public class ToyotaCar
        extends Toyota {

    public ToyotaCar(
            ToyotaAudioSystem toyotaAudioSystem,
            ToyotaClimateControl toyotaClimateControl) {
        super(toyotaAudioSystem,
              toyotaClimateControl);
    }

    @Override
    public void create() {
        new ToyotaCar(toyotaAudioSystem, toyotaClimateControl);
        System.out.printf(
                "Creating a Toyota Car with %s, %s%n",
                toyotaAudioSystem,
                toyotaClimateControl);
    }
}
