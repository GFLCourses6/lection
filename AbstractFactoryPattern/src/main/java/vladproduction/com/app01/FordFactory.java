package vladproduction.com.app01;

public class FordFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new SUVCar();
    }

    @Override
    public Bike createBike() {
        return new MountingBike();
    }
}
