package org.example.factory.rangerover;

import org.example.factory.Manufacturer;
import org.example.factory.Vehicle;
import org.example.factory.gps.GPS;
import org.example.factory.music.MusicSystem;

public class JeepRangeRoverVehicle implements Vehicle {
    private Manufacturer manufacturer;
    private MusicSystem musicSystem;
    private GPS gps;

    public JeepRangeRoverVehicle(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void createVehicle() {
        System.out.println("Build Range Rover Jeep");
    }

    @Override
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public void upgradeMusic(MusicSystem musicSystem) {
        this.musicSystem = musicSystem;
    }

    @Override
    public void upgradeGPS(GPS gps) {
        this.gps = gps;
    }
}
