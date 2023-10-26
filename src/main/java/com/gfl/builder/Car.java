package com.gfl.builder;

public class Car {

    private final String brand;
    private final String model;
    private final String color;
    private final Double price;
    private final Integer year;
    private final String gps;
    private final Integer doors;
    private final boolean hasClimateControl;
    private final boolean hasSunroof;

    public Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.price = builder.price;
        this.year = builder.year;
        this.gps = builder.gps;
        this.doors = builder.doors;
        this.hasClimateControl = builder.hasClimateControl;
        this.hasSunroof = builder.hasSunroof;
    }

    public static Builder builder(String brand, String model, String color, double price) {
        return new Builder(brand, model, color, price);
    }

    public static class Builder {
        private final String brand;
        private final String model;
        private final String color;
        private final Double price;
        private Integer year;
        private String gps;
        private Integer doors;
        private boolean hasSunroof;
        private boolean hasClimateControl;

        // required fields in the constructor:
        private Builder(String brand, String model, String color, Double price) {
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.price = price;
        }

        // additional fields:
        public Builder setYear(Integer year) {
            this.year = year;
            return this;
        }

        public Builder setGps(String gps) {
            this.gps = gps;
            return this;
        }

        public Builder setDoors(Integer doors) {
            this.doors = doors;
            return this;
        }

        public Builder setHasSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Builder setHasClimateControl(boolean hasClimateControl) {
            this.hasClimateControl = hasClimateControl;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Car{")
                .append("brand='").append(brand).append('\'')
                .append(", model='").append(model).append('\'')
                .append(", color='").append(color).append('\'')
                .append(", price=").append(price)
                .append(", year=").append(year)
                .append(", gps='").append(gps).append('\'')
                .append(", doors=").append(doors)
                .append(", hasClimateControl=").append(hasClimateControl)
                .append(", hasSunroof=").append(hasSunroof)
                .append('}').toString();
    }

    // getters
}
