package org.example.builder;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private String color;
    private Long price;
    private Integer year;
    private String gps;
    private boolean hasClimateControl;
    private String engineType;
    private String fuelType;

    public Car(){
    }

    public Car(String brand, String model, String color, Long price, Integer year, String gps, boolean hasClimateControl, String engineType, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
        this.gps = gps;
        this.hasClimateControl = hasClimateControl;
        this.engineType = engineType;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Car{")
                .append("brand='").append(brand).append('\'')
                .append(", model='").append(model).append('\'')
                .append(", color='").append(color).append('\'')
                .append(", price=").append(price).append('\'')
                .append(", year=").append(year).append('\'')
                .append(", gps='").append(gps).append('\'')
                .append(", hasClimateControl=").append(hasClimateControl).append('\'')
                .append(", engineType=").append(engineType).append('\'')
                .append(", fuelType=").append(fuelType)
                .append('}').toString();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public void setHasClimateControl(boolean hasClimateControl) {
        this.hasClimateControl = hasClimateControl;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getYear() {
        return year;
    }

    public String getGps() {
        return gps;
    }

    public boolean isHasClimateControl() {
        return hasClimateControl;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return hasClimateControl == car.hasClimateControl && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(price, car.price) && Objects.equals(year, car.year) && Objects.equals(gps, car.gps) && Objects.equals(engineType, car.engineType) && Objects.equals(fuelType, car.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, price, year, gps, hasClimateControl, engineType, fuelType);
    }

    public static class CarBuilder implements Builder{
        private String brand;
        private String model;
        private String color;
        private Long price;
        private Integer year;
        private String gps;
        private boolean hasClimateControl;
        private String engineType;
        private String fuelType;


        @Override
        public void color(String color) {
            this.color = color;
        }

        @Override
        public void model(String model) {
            this.model = model;
        }

        @Override
        public void year(Integer year) {
            this.year = year;
        }

        @Override
        public void brand(String brand) {
            this.brand = brand;
        }

        @Override
        public void price(Long price) {
            this.price = price;
        }

        @Override
        public void gps(String gps) {
            this.gps = gps;
        }

        @Override
        public void hasClimateControl(boolean climate) {
            this.hasClimateControl = climate;
        }

        @Override
        public void engineType(String engineType) {
            this.engineType = engineType;
        }

        @Override
        public void fuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        @Override
        public void print() {
            System.out.printf(
                "Car{brand='%s',\n model='%s',\n year=%d,\n color='%s',\n price=%d,\n gps=%s,\n climateControl=%s,\n engineType=%s,\n fuelType=%s}%n",
                    brand, model, year, color, price, gps, hasClimateControl, engineType, fuelType);
        }

        @Override
        public Car build() {
            return new Car(brand,
                    model,
                    color,
                    price,
                    year,
                    gps,
                    hasClimateControl,
                    engineType,
                    fuelType);
        }
    }
}