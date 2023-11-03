package com.classwork.pattern.factory.kia.audio;

public class HighEndKiaAudioSystem
        extends KiaAudioSystem {

    @Override
    public void play() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "High-End Kia AudioSystem";
    }
}
