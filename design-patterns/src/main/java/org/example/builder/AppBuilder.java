package org.example.builder;
public class AppBuilder {

    public static void main(String[] args) {
        AppBuilder app = new AppBuilder();
        app.run();
    }

    private void run() {
        // manual creation using CarBuilderManual
        Car mercedes = new CarBuilderManual()
                .brand("Mercedes-Benz")
                .model("CLA")
                .color("navy blue")
                .price(700000L)
                .year(2023)
                .gps("Modern GPS")
                .hasClimateControl(true)
                .engineType("V8")
                .fuelType("Diesel")
                .build();
        System.out.println(mercedes.toString());

        // get cars by director
        CarBuilderDirector carBuilderDirector = new CarBuilderDirector();
        Builder builder = new Car.CarBuilder();
        carBuilderDirector.constructBasic(builder);
        System.out.println("Basic car: ");
        builder.print();
        carBuilderDirector.constructSportsCar(builder);
        System.out.println("Sports car: ");
        builder.print();
        carBuilderDirector.constructBusiness(builder);
        System.out.println("Business car: ");
        builder.print();
    }
}
