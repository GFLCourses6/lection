package org.example.builder;

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