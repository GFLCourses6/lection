package com.classwork.pattern.factory.toyota.creator;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystem;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControl;

public abstract class Toyota
        implements Vehicle {

    ToyotaAudioSystem toyotaAudioSystem;
    ToyotaClimateControl toyotaClimateControl;

    protected Toyota(
            final ToyotaAudioSystem toyotaAudioSystem,
            final ToyotaClimateControl toyotaClimateControl) {
        this.toyotaAudioSystem = toyotaAudioSystem;
        this.toyotaClimateControl = toyotaClimateControl;
    }

    public void upgradeAudio(
            final ToyotaAudioSystem audioSystem) {
        this.toyotaAudioSystem = audioSystem;
    }

    public void upgradeClimate(
            final ToyotaClimateControl climateControl) {
        this.toyotaClimateControl = climateControl;
    }
}
