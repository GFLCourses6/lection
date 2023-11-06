package vladproduction.com.app03.factories;

import vladproduction.com.app03.Car;

public abstract class Factory {

    public abstract Car createCar();

    public Car assembleCar(){
        Car car = createCar();
        System.out.println("Assembling: " + car.getClass().getSimpleName());
        car.assemble();
        System.out.println("Car completed!");
        return car;
    }

}
