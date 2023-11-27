package org.example.factory.bmw;

import org.example.factory.Manufacturer;
import org.example.factory.Vehicle;
import org.example.factory.gps.GPS;
import org.example.factory.music.MusicSystem;

public class MiniBMWVehicle implements Vehicle {
    private Manufacturer manufacturer;
    private MusicSystem musicSystem;
    private GPS gps;

    public MiniBMWVehicle(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void createVehicle() {
        System.out.println("Build BMW Mini");
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
