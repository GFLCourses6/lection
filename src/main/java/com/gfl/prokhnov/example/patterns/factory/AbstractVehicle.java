package com.gfl.prokhnov.example.patterns.factory;

import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;

public abstract class AbstractVehicle implements Vehicle{
    protected String model;
    protected String type;
    protected AudioSystems audioSystem;
    protected ClimateControlSystems climateControlSystem;
    protected GpsSystems gpsSystem;

    public AbstractVehicle(String model,
                           String type,
                           AudioSystems audioSystem,
                           ClimateControlSystems climateControlSystem,
                           GpsSystems gpsSystem) {
        this.model = model;
        this.type = type;
        this.audioSystem = audioSystem;
        this.climateControlSystem = climateControlSystem;
        this.gpsSystem = gpsSystem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AudioSystems getAudioSystem() {
        return audioSystem;
    }

    public void setAudioSystem(AudioSystems audioSystem) {
        this.audioSystem = audioSystem;
    }

    public ClimateControlSystems getClimateControlSystem() {
        return climateControlSystem;
    }

    public void setClimateControlSystem(ClimateControlSystems climateControlSystem) {
        this.climateControlSystem = climateControlSystem;
    }

    public GpsSystems getGpsSystem() {
        return gpsSystem;
    }

    public void setGpsSystem(GpsSystems gpsSystem) {
        this.gpsSystem = gpsSystem;
    }

    @Override
    public void createVehicle() {
        String vehicle = "\n-----------------" +
                "\nVehicle" +
                "\nModel: " + model +
                "\nType: " + type +
                "\nAudioSystem: " + audioSystem.getModel() +
                "\nGpsSystem: " + gpsSystem.getModel() +
                "\nClimateControlSystem: " + climateControlSystem.getModel() +
                "\n-----------------";
        System.out.println(vehicle);
    }

    @Override
    public String toString() {
        return "\n-----------------" +
                "\nVehicle" +
                "\nModel: " + model +
                "\nType: " + type +
                "\nAudioSystem: " + audioSystem.getModel() +
                "\nGpsSystem: " + gpsSystem.getModel() +
                "\nClimateControlSystem: " + climateControlSystem.getModel() +
                "\n-----------------";
    }
}
