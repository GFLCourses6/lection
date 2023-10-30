package com.gfl.prokhnov.builder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderApp {

    private static final Logger LOGGER = LogManager.getLogger(BuilderApp.class.getName());

    public static void main(String[] args) {
        CarBuilderDirector carBuilderDirector = new CarBuilderDirector();
        CarBuilder builder = new CarBuilder();

        carBuilderDirector.constructBasic(builder);

        Car car = builder.getCar();
        LOGGER.info(car);

        CarBuilderManual carBuilderManual = new CarBuilderManual();
        carBuilderDirector.constructComfort(carBuilderManual);
        carBuilderManual.print();

    }
}
