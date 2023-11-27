package org.example.factory.rangerover.gps;

public class LowEndRangeRoverGPS implements RangeRoverGPS{
    @Override
    public void gps() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Low-end Range Rover GPS ";
    }
}
