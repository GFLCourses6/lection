package org.example.factory.rangerover.gps;

public class HighEndRangeRoverGPS implements RangeRoverGPS{
    @Override
    public void gps() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "High-end Range Rover GPS ";
    }
}
