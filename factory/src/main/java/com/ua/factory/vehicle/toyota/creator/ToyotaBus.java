package com.ua.factory.vehicle.toyota.creator;

import com.ua.factory.vehicle.toyota.audio.ToyotaAudioSystem;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;

public class ToyotaBus extends Toyota {

    protected ToyotaBus(
            ToyotaAudioSystem toyotaAudioSystem,
            ToyotaClimateControl toyotaClimateControl) {
        super(toyotaAudioSystem,
              toyotaClimateControl);
    }

    @Override
    public void create() {
        new ToyotaBus(toyotaAudioSystem, toyotaClimateControl);
        System.out.printf(
                "Creating a Toyota Bus with %s, %s%n",
                toyotaAudioSystem, toyotaClimateControl);
    }
}
