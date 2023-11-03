package com.classwork.pattern.factory.audio;

import com.classwork.pattern.factory.Vehicle;

public class AudioSystemBuildFactory {

    AudioSystemFacade facade;
    private final Vehicle vehicle;

    public AudioSystemBuildFactory(
            Vehicle vehicle) {
        this.vehicle = vehicle;
        this.facade = AudioSystemFacade.getInstanceAudio();
    }

    public void upgrade(){
        facade.upgrade(vehicle);
    }
}
