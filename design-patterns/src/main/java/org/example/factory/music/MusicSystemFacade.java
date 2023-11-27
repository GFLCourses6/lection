package org.example.factory.music;

import org.example.factory.Manufacturer;
import org.example.factory.Vehicle;
import org.example.factory.bmw.music.BMWMusicSystem;
import org.example.factory.bmw.music.BMWMusicSystemCreator;
import org.example.factory.rangerover.music.RangeRoverMusicSystem;
import org.example.factory.rangerover.music.RangeRoverMusicSystemCreator;

public class MusicSystemFacade {
    private final BMWMusicSystemCreator bmwMusicSystemCreator;
    private final RangeRoverMusicSystemCreator rangeRoverMusicSystemCreator;

    public MusicSystemFacade() {
        this.bmwMusicSystemCreator = new BMWMusicSystemCreator();
        this.rangeRoverMusicSystemCreator = new RangeRoverMusicSystemCreator();
    }
    public MusicSystemFacade(BMWMusicSystemCreator bmwMusicSystemCreator, RangeRoverMusicSystemCreator rangeRoverMusicSystemCreator) {
        this.bmwMusicSystemCreator = bmwMusicSystemCreator;
        this.rangeRoverMusicSystemCreator = rangeRoverMusicSystemCreator;
    }

    private static final class MusicSystemFacadeHolder {
        private static final MusicSystemFacade INSTANCE =
                new MusicSystemFacade();
    }

    public static MusicSystemFacade getInstanceAudio() {
        return MusicSystemFacadeHolder.INSTANCE;
    }

    public void upgradeHighEnd(Vehicle vehicle){
        if(vehicle.getManufacturer().equals(Manufacturer.BMW)){
            vehicle.upgradeMusic(getBMWHighEndMusicSystem());
        } else if(vehicle.getManufacturer().equals(Manufacturer.RANGE_ROVER)){
            vehicle.upgradeMusic(getRangeRoverHighEndMusicSystem());
        }
    }

    public void upgradeLowEnd(Vehicle vehicle){
        if(vehicle.getManufacturer().equals(Manufacturer.BMW)){
            vehicle.upgradeMusic(getBMWLowEndMusicSystem());
        } else if(vehicle.getManufacturer().equals(Manufacturer.RANGE_ROVER)){
            vehicle.upgradeMusic(getRangeRoverLowEndMusicSystem());
        }
    }

    private BMWMusicSystem getBMWHighEndMusicSystem() {
        return bmwMusicSystemCreator.createHighEndMusicSystem();
    }

    private BMWMusicSystem getBMWLowEndMusicSystem() {
        return bmwMusicSystemCreator.createLowEndMusicSystem();
    }

    private RangeRoverMusicSystem getRangeRoverHighEndMusicSystem() {
        return rangeRoverMusicSystemCreator.createHighEndMusicSystem();
    }

    private RangeRoverMusicSystem getRangeRoverLowEndMusicSystem() {
        return rangeRoverMusicSystemCreator.createLowEndMusicSystem();
    }
}
