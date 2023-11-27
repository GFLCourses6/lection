package org.example.factory.bmw.gps;

public class LowEndBMWGPS implements BMWGPS{
    @Override
    public void gps() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Low-End BMW GPS";
    }
}
