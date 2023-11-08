package com.classwork.pattern.factory.kia.creator;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.VehicleFactory;
import com.classwork.pattern.factory.kia.audio.KiaAudioSystem;
import com.classwork.pattern.factory.kia.climate.KiaClimateControl;

import static com.classwork.pattern.factory.audio.AudioSystemFacade.getInstanceAudio;
import static com.classwork.pattern.factory.climate.ClimateControlFacade.getInstanceClimate;

public class KiaFactory
        implements VehicleFactory {

    private final KiaAudioSystem audio;
    private final KiaClimateControl climate;

    public KiaFactory() {
        this.audio = getInstanceAudio().getBasicKiaAudio();
        this.climate = getInstanceClimate().getBasicKiaClimate();
    }

    @Override
    public Vehicle createBus() {
        return new KiaBus(audio, climate);
    }

    @Override
    public Vehicle createTruck() {
        return new KiaTruck(audio, climate);
    }

    @Override
    public Vehicle createCar() {
        return new KiaCar(audio, climate);
    }
}
