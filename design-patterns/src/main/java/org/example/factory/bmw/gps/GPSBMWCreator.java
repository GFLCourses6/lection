package org.example.factory.bmw.gps;

import org.example.factory.gps.GPSFactory;

public class GPSBMWCreator implements GPSFactory {
    @Override
    public BMWGPS createHighEndGpsSystem() {
        HighEndBMWGPS gps = new HighEndBMWGPS();
        System.out.println(gps);
        return gps;
    }

    @Override
    public BMWGPS createLowEndGpsSystem() {
        LowEndBMWGPS gps = new LowEndBMWGPS();
        System.out.println(gps);
        return gps;
    }
}
