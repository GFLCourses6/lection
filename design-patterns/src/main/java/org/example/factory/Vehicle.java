package org.example.factory;

import org.example.factory.gps.GPS;
import org.example.factory.music.MusicSystem;

public interface Vehicle {

    void createVehicle();

    Manufacturer getManufacturer();

    void upgradeMusic(MusicSystem musicSystem);

    void upgradeGPS(GPS gps);
}
