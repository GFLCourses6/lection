package vladproduction.com.app01;

public class MainApp01 {
    public static void main(String[] args) {

        VehicleFactory hondaFactory = new HondaFactory();
        Car hondaCar = hondaFactory.createCar();
        Bike hondaBike = hondaFactory.createBike();

        VehicleFactory fordFactory = new FordFactory();
        Car fordCar = fordFactory.createCar();
        Bike fordBike = fordFactory.createBike();

        hondaCar.drive();
        hondaBike.ride();

        fordCar.drive();
        fordBike.ride();
    }
}
