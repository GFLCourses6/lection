package ua.chemerys;

import ua.chemerys.factory.BuildFactory;
import ua.chemerys.factory.VehicleFactory;
import ua.chemerys.factory.kia.KiaFactory;
import ua.chemerys.factory.toyota.ToyotaFactory;

public class Main {
    public static void main(String[] args) {

        VehicleFactory vehicleKiaFactory = new KiaFactory();
        BuildFactory buildKiaFactory = new BuildFactory(vehicleKiaFactory);

        VehicleFactory vehicleToyotaFactory = new ToyotaFactory();
        BuildFactory buildToyotaFactory = new BuildFactory(vehicleToyotaFactory);

        buildKiaFactory.buildSUV();

        buildToyotaFactory.buildMini();


    }
}