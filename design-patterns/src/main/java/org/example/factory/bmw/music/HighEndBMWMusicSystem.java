package org.example.factory.bmw.music;

public class HighEndBMWMusicSystem implements BMWMusicSystem{
    @Override
    public void music() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "High-end BMW Music System";
    }
}
