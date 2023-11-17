package com.ua.factory.vehicle.toyota.audio;

import com.ua.factory.vehicle.audio.AudioSystemFactory;

public class ToyotaAudioSystemBuilder
        implements AudioSystemFactory {

    @Override
    public ToyotaAudioSystem createBasic() {
        ToyotaAudioSystem basicAudioSystem =
                new BasicToyotaAudioSystem();
        System.out.println(basicAudioSystem);
        return basicAudioSystem;
    }

    @Override
    public ToyotaAudioSystem createHighEnd() {
        ToyotaAudioSystem highEndAudioSystem =
                new HighEndToyotaAudioSystem();
        System.out.println(highEndAudioSystem);
        return highEndAudioSystem;
    }
}
