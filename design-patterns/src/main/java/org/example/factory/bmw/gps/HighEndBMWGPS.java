package org.example.factory.bmw.gps;

public class HighEndBMWGPS implements BMWGPS{
    @Override
    public void gps() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "High-End BMW GPS";
    }
}
