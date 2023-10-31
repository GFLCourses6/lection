package vladproduction.com.app02.main;

import vladproduction.com.app02.builder.Builder;
import vladproduction.com.app02.builder.HouseBuilder;
import vladproduction.com.app02.builder.HouseBuilderExclusive;
import vladproduction.com.app02.director.Director;
import vladproduction.com.app02.model.House;

public class MainApp {
    public static void main(String[] args) {

        HouseBuilder builder = new HouseBuilder();
        HouseBuilderExclusive builderExclusive = new HouseBuilderExclusive();

        Director director = new Director();

        director.constructMANSION(builder);
        House mansion = builder.getResult();
        System.out.println(mansion);

        director.constructMANSION(builderExclusive);
        builderExclusive.print();

    }
}
