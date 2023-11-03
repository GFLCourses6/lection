package com.classwork.pattern.factory.toyota.creator;

import com.classwork.pattern.factory.Vehicle;
import com.classwork.pattern.factory.VehicleFactory;
import com.classwork.pattern.factory.climate.ClimateControlFacade;
import com.classwork.pattern.factory.toyota.audio.ToyotaAudioSystem;
import com.classwork.pattern.factory.toyota.climate.ToyotaClimateControl;

import static com.classwork.pattern.factory.audio.AudioSystemFacade.getInstanceAudio;

public class ToyotaFactory implements VehicleFactory {

    private final ToyotaAudioSystem audio;
    private final ToyotaClimateControl climate;

    public ToyotaFactory() {
        this.audio = getInstanceAudio().getBasicToyotaAudio();
        this.climate = ClimateControlFacade.getInstanceClimate().getBasicToyotaClimate();
    }

    @Override
    public Vehicle createBus() {
        return new ToyotaBus(audio, climate);
    }

    @Override
    public Vehicle createTruck() {
        return new ToyotaTruck(audio, climate);
    }

    @Override
    public Vehicle createCar() {
        return new ToyotaCar(audio, climate);
    }
}