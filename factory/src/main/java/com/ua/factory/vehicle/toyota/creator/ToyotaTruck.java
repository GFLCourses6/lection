package com.ua.factory.vehicle.toyota.creator;

import com.ua.factory.vehicle.toyota.audio.ToyotaAudioSystem;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;

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
