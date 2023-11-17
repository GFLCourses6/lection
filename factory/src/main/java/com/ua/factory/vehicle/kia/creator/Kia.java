package com.ua.factory.vehicle.kia.creator;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.kia.audio.KiaAudioSystem;
import com.ua.factory.vehicle.kia.climate.KiaClimateControl;

import java.util.Objects;

public abstract class Kia
        implements Vehicle {
    protected KiaAudioSystem kiaAudioSystem;
    protected KiaClimateControl kiaClimateControl;

    protected Kia(
            final KiaAudioSystem kiaAudioSystem,
            final KiaClimateControl kiaClimateControl) {
        this.kiaAudioSystem = kiaAudioSystem;
        this.kiaClimateControl = kiaClimateControl;
    }

    public void upgradeAudio(
            final KiaAudioSystem audioSystem) {
        this.kiaAudioSystem = audioSystem;
    }

    public void upgradeClimate(
            final KiaClimateControl climateControl) {
        this.kiaClimateControl = climateControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kia kia = (Kia) o;
        return Objects.equals(kiaAudioSystem,
                kia.kiaAudioSystem) && Objects.equals(kiaClimateControl,
                kia.kiaClimateControl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kiaAudioSystem, kiaClimateControl);
    }
}
