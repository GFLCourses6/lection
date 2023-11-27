package org.example.factory.bmw.music;

public class LowEndBMWMusicSystem implements BMWMusicSystem{
    @Override
    public void music() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Low-end BMW Music System";
    }
}
