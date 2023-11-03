package com.classwork.pattern.factory.toyota.audio;

public class BasicToyotaAudioSystem
        extends ToyotaAudioSystem {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Basic Toyota AudioSystem";
    }
}
