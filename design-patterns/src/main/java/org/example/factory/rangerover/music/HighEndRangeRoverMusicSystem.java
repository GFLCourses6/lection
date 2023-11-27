package org.example.factory.rangerover.music;

public class HighEndRangeRoverMusicSystem implements RangeRoverMusicSystem{
    @Override
    public void music() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "High-end Range Rover Music System";
    }
}
