package vladproduction.com.app01;

public class HondaFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new SedanCar();
    }

    @Override
    public Bike createBike() {
        return new RoadBike();
    }
}
