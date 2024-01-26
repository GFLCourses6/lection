package ua.chemerys.factory;

public class BuildFactory {

    private Vehicle mini;
    private Vehicle suv;
    private Vehicle jeep;

    public BuildFactory(VehicleFactory vehicleFactory) {
        this.jeep = vehicleFactory.buildJeep();
        this.mini = vehicleFactory.buildMini();
        this.suv = vehicleFactory.buildSUV();
    }

    public void buildMini() {
        mini.createVehicle();
    }

    public void buildSUV() {
        suv.createVehicle();
    }

    public void buildJeep() {
        jeep.createVehicle();
    }
}
