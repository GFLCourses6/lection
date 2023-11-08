package com.classwork.pattern.factory.audio;

import com.classwork.pattern.factory.BuildFactory;
import com.classwork.pattern.factory.Vehicle;

import static com.classwork.pattern.factory.audio.AudioSystemFacade.getInstanceAudio;

public class AudioSystemBuildFactory
        implements BuildFactory {

    AudioSystemFacade facade;
    private final Vehicle vehicle;

    public AudioSystemBuildFactory(
            Vehicle vehicle) {
        this.vehicle = vehicle;
        this.facade = getInstanceAudio();
    }

    @Override
    public void upgrade() {
        facade.upgrade(vehicle);
    }
}
