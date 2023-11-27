package org.example.factory.rangerover.gps;

import org.example.factory.gps.GPSFactory;

public class GPSRangeRoverCreator implements GPSFactory{
    @Override
    public HighEndRangeRoverGPS createHighEndGpsSystem() {
        HighEndRangeRoverGPS gps = new HighEndRangeRoverGPS();
        System.out.println(gps);
        return gps;
    }

    @Override
    public LowEndRangeRoverGPS createLowEndGpsSystem() {
        LowEndRangeRoverGPS gps = new LowEndRangeRoverGPS();
        System.out.println(gps);
        return gps;
    }
}
