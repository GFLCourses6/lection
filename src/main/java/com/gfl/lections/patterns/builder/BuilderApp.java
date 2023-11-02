package com.gfl.lections.patterns.builder;

public class BuilderApp {
    public static void main(String[] args) {
        CarBuilderDirector carBuilderDirector = new CarBuilderDirector();
        CarBuilder carBuilder = new CarBuilder();
        CarBuilderManual carBuilderManual = new CarBuilderManual();
        carBuilderDirector.constructBasic(carBuilder);
        carBuilderDirector.constructBasic(carBuilderManual);

        Car car = carBuilder.getCar();
        System.out.println(car);

        carBuilderManual.print();
    }
}
