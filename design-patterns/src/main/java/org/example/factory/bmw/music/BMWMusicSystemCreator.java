package org.example.factory.bmw.music;

import org.example.factory.music.MusicSystemFactory;

public class BMWMusicSystemCreator implements MusicSystemFactory {

    @Override
    public BMWMusicSystem createHighEndMusicSystem() {
        BMWMusicSystem highEndBMWMusicSystem = new HighEndBMWMusicSystem();
        System.out.println(highEndBMWMusicSystem);
        return highEndBMWMusicSystem;
    }

    @Override
    public BMWMusicSystem createLowEndMusicSystem() {
        BMWMusicSystem lowEndBMWMusicSystem = new LowEndBMWMusicSystem();
        System.out.println(lowEndBMWMusicSystem);
        return lowEndBMWMusicSystem;
    }
}
