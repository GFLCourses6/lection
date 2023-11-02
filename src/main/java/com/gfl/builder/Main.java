package com.gfl.builder;

import com.gfl.builder.model.Car;

public class Main {
    public static void main(String[] args) {
        CarBuilderDirector carBuilderDirector = new CarBuilderDirector();
        CarBuilder builder = new CarBuilder();

        carBuilderDirector.constructBasic(builder);

        Car car = builder.getCar();

        CarBuilderManual carBuilderManual = new CarBuilderManual();
        carBuilderDirector.constructComfortPlus(carBuilderManual);
        System.out.println(carBuilderManual.infoCar());
    }
}
