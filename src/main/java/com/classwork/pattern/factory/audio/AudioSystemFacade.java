package com.classwork.pattern.factory.audio;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.kia.audio.KiaAudioSystemBuilder;
import com.classwork.pattern.factory.kia.creator.Kia;
import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystem;
import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystemBuilder;
import com.classwork.pattern.factory.toyota.creator.Toyota;

public class AudioSystemFacade {

    private final KiaAudioSystemBuilder kiaAudioBuilder;
    private final ToyotaAudioSystemBuilder toyotaAudioBuilder;

    public AudioSystemFacade() {
        this.kiaAudioBuilder = new KiaAudioSystemBuilder();
        this.toyotaAudioBuilder = new ToyotaAudioSystemBuilder();
    }

    public AudioSystemFacade(
            KiaAudioSystemBuilder kiaAudioBuilder,
            ToyotaAudioSystemBuilder toyotaAudioBuilder) {
        this.kiaAudioBuilder = kiaAudioBuilder;
        this.toyotaAudioBuilder = toyotaAudioBuilder;
    }

    private static final class AudioSystemFacadeHolder {
        private static final AudioSystemFacade INSTANCE =
                new AudioSystemFacade();
    }

    public static AudioSystemFacade getInstanceAudio() {
        return AudioSystemFacadeHolder.INSTANCE;
    }

    public void upgrade(Vehicle vehicle) {
        if (vehicle instanceof Kia kia) {
            kia.upgradeAudio(getHighEndKiaAudio());
        } else if (vehicle instanceof Toyota toyota) {
            toyota.upgradeAudio(getHighEndToyotaAudio());
        }
    }

    public KiaAudioSystem getBasicKiaAudio() {
        return kiaAudioBuilder.createBasic();
    }

    public KiaAudioSystem getHighEndKiaAudio() {
        return kiaAudioBuilder.createHighEnd();
    }

    public ToyotaAudioSystem getBasicToyotaAudio() {
        return toyotaAudioBuilder.createBasic();
    }

    public ToyotaAudioSystem getHighEndToyotaAudio() {
        return toyotaAudioBuilder.createHighEnd();
    }
}
