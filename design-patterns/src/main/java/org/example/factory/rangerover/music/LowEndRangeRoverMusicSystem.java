package org.example.factory.rangerover.music;

public class LowEndRangeRoverMusicSystem implements RangeRoverMusicSystem{
    @Override
    public void music() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Low-End Range Rover Music System";
    }
}
