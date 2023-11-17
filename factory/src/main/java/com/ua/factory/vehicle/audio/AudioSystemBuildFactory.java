package com.ua.factory.vehicle.audio;

import com.ua.factory.vehicle.BuildFactory;
import com.ua.factory.vehicle.Vehicle;

import static com.ua.factory.vehicle.audio.AudioSystemFacade.getInstanceAudio;

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
