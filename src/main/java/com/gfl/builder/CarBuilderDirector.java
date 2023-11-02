package com.gfl.builder;

public class CarBuilderDirector {
    public void constructBasic(Builder builder){
        builder.setColor("White");
        builder.setBrand("Toyota");
        builder.setYear(2023);
        builder.setModel("Yaris");
    }
    public void constructComfort(Builder builder){
        builder.setColor("White");
        builder.setBrand("Toyota");
        builder.setYear(2023);
        builder.setModel("Yaris");
        builder.setGps("Yes");
    }
    public void constructComfortPlus(Builder builder){
        builder.setColor("White");
        builder.setBrand("Toyota");
        builder.setYear(2023);
        builder.setModel("Yaris");
        builder.setArtificialIntelligence("Yes");
        builder.setGps("Yes");
    }
}
