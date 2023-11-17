package com.ua.factory.vehicle.toyota.creator;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.VehicleFactory;
import com.ua.factory.vehicle.climate.ClimateControlFacade;
import com.ua.factory.vehicle.toyota.audio.ToyotaAudioSystem;
import com.ua.factory.vehicle.toyota.climate.ToyotaClimateControl;

import static com.ua.factory.vehicle.audio.AudioSystemFacade.getInstanceAudio;

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
