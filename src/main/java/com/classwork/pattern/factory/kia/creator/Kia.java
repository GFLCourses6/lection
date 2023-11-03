package com.classwork.pattern.factory.kia.creator;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.kia.climate.KiaClimateControl;

public abstract class Kia
        implements Vehicle {
    KiaAudioSystem kiaAudioSystem;
    KiaClimateControl kiaClimateControl;

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
}
