package vladproduction.com.app03.factories;

import vladproduction.com.app03.Car;
import vladproduction.com.app03.SUV;

public class SUVFactory extends Factory {
    @Override
    public Car createCar() {
        return new SUV();
    }

}
