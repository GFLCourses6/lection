package com.ua.factory.vehicle.toyota.creator;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.toyota.audio.ToyotaAudioSystem;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toyota toyota = (Toyota) o;
        return Objects.equals(toyotaAudioSystem,
                toyota.toyotaAudioSystem) && Objects.equals(
                toyotaClimateControl, toyota.toyotaClimateControl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toyotaAudioSystem, toyotaClimateControl);
    }
}
