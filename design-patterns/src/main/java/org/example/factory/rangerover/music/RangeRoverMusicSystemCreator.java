package org.example.factory.rangerover.music;

import org.example.factory.music.MusicSystemFactory;

public class RangeRoverMusicSystemCreator implements MusicSystemFactory {
    @Override
    public RangeRoverMusicSystem createHighEndMusicSystem() {
        RangeRoverMusicSystem rangeRoverMusicSystem = new HighEndRangeRoverMusicSystem();
        System.out.println(rangeRoverMusicSystem);
        return rangeRoverMusicSystem;
    }

    @Override
    public RangeRoverMusicSystem createLowEndMusicSystem() {
        RangeRoverMusicSystem rangeRoverMusicSystem = new LowEndRangeRoverMusicSystem();
        System.out.println(rangeRoverMusicSystem);
        return rangeRoverMusicSystem;
    }
}
