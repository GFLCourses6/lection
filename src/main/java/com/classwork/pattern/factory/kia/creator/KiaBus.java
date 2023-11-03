package com.classwork.pattern.factory.kia.creator;

import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.kia.climate.KiaClimateControl;

public class KiaBus extends Kia {

    public KiaBus(
            KiaAudioSystem kiaAudio,
            KiaClimateControl kiaClimate) {
        super(kiaAudio, kiaClimate);
    }

    @Override
    public void create() {
        new KiaBus(kiaAudioSystem, kiaClimateControl);
        System.out.printf(
                "Creating a Kia Bus with %s, %s%n",
                kiaAudioSystem, kiaClimateControl);
    }
}
