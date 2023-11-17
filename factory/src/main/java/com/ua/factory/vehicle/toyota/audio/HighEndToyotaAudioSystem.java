package com.ua.factory.vehicle.toyota.audio;

public class HighEndToyotaAudioSystem
        extends ToyotaAudioSystem {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "High-End Toyota AudioSystem";
    }
}
