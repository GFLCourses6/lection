package org.example.factory.music;

import org.example.factory.BuildFactory;
import org.example.factory.Vehicle;
import static org.example.factory.music.MusicSystemFacade.getInstanceAudio;

public class MusicSystemBuildFactory implements BuildFactory {
    private MusicSystemFacade musicSystemFacade;
    private Vehicle vehicle;

    public MusicSystemBuildFactory(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.musicSystemFacade = getInstanceAudio();
    }

    @Override
    public void upgradeWhipHighEnd() {
        musicSystemFacade.upgradeHighEnd(vehicle);
    }

    @Override
    public void upgradeWhipLowEnd() {
        musicSystemFacade.upgradeLowEnd(vehicle);
    }
}
