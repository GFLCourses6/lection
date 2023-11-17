package com.ua.factory.vehicle.kia.creator;

import com.ua.factory.vehicle.Vehicle;
import com.ua.factory.vehicle.VehicleFactory;
import com.ua.factory.vehicle.audio.AudioSystemFacade;
import com.ua.factory.vehicle.climate.ClimateControlFacade;
import com.ua.factory.vehicle.kia.audio.KiaAudioSystem;
import com.ua.factory.vehicle.kia.climate.KiaClimateControl;

public class KiaFactory
        implements VehicleFactory {

    private final KiaAudioSystem audio;
    private final KiaClimateControl climate;

    public KiaFactory() {
        this.audio = AudioSystemFacade.getInstanceAudio().getBasicKiaAudio();
        this.climate = ClimateControlFacade.getInstanceClimate().getBasicKiaClimate();
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
