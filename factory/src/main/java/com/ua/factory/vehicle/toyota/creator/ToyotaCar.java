package com.ua.factory.vehicle.toyota.creator;

import com.ua.factory.vehicle.toyota.audio.ToyotaAudioSystem;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;

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
