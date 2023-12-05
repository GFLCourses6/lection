package com.gfl.prokhnov.example.patterns.factory;

import com.gfl.prokhnov.example.patterns.factory.audi.AudiFactory;
import com.gfl.prokhnov.example.patterns.factory.kia.KiaFactory;
import com.gfl.prokhnov.example.patterns.factory.services.AudioService;
import com.gfl.prokhnov.example.patterns.factory.services.ClimateControlService;
import com.gfl.prokhnov.example.patterns.factory.services.GpsSystemService;
import com.gfl.prokhnov.example.patterns.factory.services.updates.AudioSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.ClimateControlSystems;
import com.gfl.prokhnov.example.patterns.factory.services.updates.GpsSystems;
import com.gfl.prokhnov.example.patterns.factory.toyota.ToyotaFactory;

public class FactoryApp {
    public static void main(String[] args) {

        System.out.println("------------TOYOTA------------");
        // Toyota factory
        VehicleFactory vehicleToyotaFactory = new ToyotaFactory();
        BuildFactory buildToyotaFactory = new BuildFactory(vehicleToyotaFactory);

        // Build different toyota vehicles
        Vehicle toyotaJeep = buildToyotaFactory.buildJeep();
        Vehicle toyotaSUV = buildToyotaFactory.buildSUV();
        Vehicle toyotaMini = buildToyotaFactory.buildMini();

        // Update some systems
        AudioService audioService = new AudioService();
        audioService.update(toyotaJeep, new AudioSystems("Super"));
        toyotaJeep.createVehicle();

        GpsSystemService gpsSystemService = new GpsSystemService();
        gpsSystemService.update(toyotaSUV, new GpsSystems("Super"));
        toyotaSUV.createVehicle();

        ClimateControlService climateControlService = new ClimateControlService();
        climateControlService.update(toyotaMini, new ClimateControlSystems("Super"));
        toyotaMini.createVehicle();

        System.out.println("------------AUDI------------");
        // Toyota factory
        VehicleFactory vehicleAudiFactory = new AudiFactory();
        BuildFactory buildAudiFactory = new BuildFactory(vehicleAudiFactory);

        // Build different toyota vehicles
        Vehicle audiJeep = buildAudiFactory.buildJeep();
        Vehicle audiSUV = buildAudiFactory.buildSUV();
        Vehicle audiMini = buildAudiFactory.buildMini();

        // Update some systems
        audioService.update(audiJeep, new AudioSystems("Super"));
        audiJeep.createVehicle();

        gpsSystemService.update(audiSUV, new GpsSystems("Super"));
        audiSUV.createVehicle();

        climateControlService.update(audiMini, new ClimateControlSystems("Super"));
        audiMini.createVehicle();

        System.out.println("------------KIA------------");
        // Toyota factory
        VehicleFactory vehicleKiaFactory = new KiaFactory();
        BuildFactory buildKiaFactory = new BuildFactory(vehicleKiaFactory);

        // Build different toyota vehicles
        Vehicle kiaJeep = buildKiaFactory.buildJeep();
        Vehicle kiaSUV = buildKiaFactory.buildSUV();
        Vehicle kiaMini = buildKiaFactory.buildMini();

        // Update some systems
        audioService.update(kiaJeep, new AudioSystems("Super"));
        kiaJeep.createVehicle();

        gpsSystemService.update(kiaSUV, new GpsSystems("Super"));
        kiaSUV.createVehicle();

        climateControlService.update(kiaMini, new ClimateControlSystems("Super"));
        kiaMini.createVehicle();



    }
}
