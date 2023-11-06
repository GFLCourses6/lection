package vladproduction.com.app03.factories;

import vladproduction.com.app03.Car;
import vladproduction.com.app03.Sport;

public class SportFactory extends Factory {
    @Override
    public Car createCar() {
        return new Sport();
    }

}
