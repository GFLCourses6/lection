package org.example.factory.gps;

import org.example.factory.BuildFactory;
import org.example.factory.Vehicle;
import static org.example.factory.gps.GPSFacade.getInstance;

public class GPSBuildFactory implements BuildFactory {

    private  GPSFacade facade;

    private Vehicle vehicle;

    public GPSBuildFactory(Vehicle vehicle) {
        this.facade = getInstance();
        this.vehicle = vehicle;
    }

    @Override
    public void upgradeWhipHighEnd() {
        facade.upgradeHighEnd(vehicle);
    }

    @Override
    public void upgradeWhipLowEnd() {
        facade.upgradeLowEnd(vehicle);
    }
}
