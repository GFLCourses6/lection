package com.ua.factory.vehicle.kia.audio;

public class BasicKiaAudioSystem
        extends KiaAudioSystem {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Basic Kia AudioSystem";
    }
}
