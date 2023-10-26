package com.classwork.pattern.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuilderApp {
    private static final Logger LOGGER = LogManager.getLogger(BuilderApp.class);

    public static void main(String[] args) {

        CarBuilderDirector carBuilderDirector = new CarBuilderDirector();
        Builder builder = new CarBuilder();
        carBuilderDirector.constructBasic(builder);
        carBuilderDirector.constructComfort(builder);
        carBuilderDirector.constructSportsCar(builder);
        builder.print();

        Car carBuilderManual = new CarBuilderManual()
                .color("Red")
                .model("Sedan")
                .year(2023)
                .brand("GTR-400")
                .price(25000L)
                .gps(true)
                .climateControl(true)
                .build();

        LOGGER.info(carBuilderManual);
    }
}
