package com.classwork.pattern.factory.kia.audio;

import com.classwork.pattern.factory.audio.AudioSystemFactory;

public class KiaAudioSystemBuilder
        implements AudioSystemFactory {

    @Override
    public KiaAudioSystem createBasic() {
        KiaAudioSystem basicAudioSystem
                = new BasicKiaAudioSystem();
        System.out.println(basicAudioSystem);
        return basicAudioSystem;
    }

    @Override
    public KiaAudioSystem createHighEnd() {
        KiaAudioSystem highEndAudioSystem
                = new HighEndKiaAudioSystem();
        System.out.println(highEndAudioSystem);
        return highEndAudioSystem;
    }
}
