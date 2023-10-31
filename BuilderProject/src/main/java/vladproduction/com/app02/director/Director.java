package vladproduction.com.app02.director;

import vladproduction.com.app02.builder.Builder;
import vladproduction.com.app02.builder.HouseBuilder;
import vladproduction.com.app02.builder.HouseBuilderExclusive;
import vladproduction.com.app02.model.*;

public class Director {

    public void constructCOTTAGE(Builder builder){
        builder.setHouseType(HouseType.COTTAGE);
        builder.setLevels(2);
        builder.setWall(new Wall(Wall.WallType.BRICK));
        builder.setWindows(new Windows(Windows.WindowFrame.WOOD));
        builder.setAmountWindows(7);
        builder.setRoof(new Roof(Roof.RoofType.SPAN_ROOF, "wood/slate"));
        builder.setDoors(new Doors("wood"));

    }

    public void constructMANSION(Builder builder){
        builder.setHouseType(HouseType.MANSION);
        builder.setLevels(3);
        builder.setWall(new Wall(Wall.WallType.AERATED_CONCRETE));
        builder.setWindows(new Windows(Windows.WindowFrame.WOOD));
        builder.setAmountWindows(7);
        builder.setRoof(new Roof(Roof.RoofType.MULTI_SLOPE, "wood/tiles"));
        builder.setDoors(new Doors("wood/metal"));
    }

    public void constructTOWNHOUSE(Builder builder){
        builder.setHouseType(HouseType.TOWNHOUSE);
        builder.setLevels(2);
        builder.setWall(new Wall(Wall.WallType.SANDWICH_PANEL));
        builder.setWindows(new Windows(Windows.WindowFrame.PLASTIC));
        builder.setAmountWindows(7);
        builder.setRoof(new Roof(Roof.RoofType.FLAT, "metal/slate"));
        builder.setDoors(new Doors("plastic"));

    }

    public void constructMANSION(HouseBuilderExclusive builder){
        builder.setHouseType(HouseType.MANSION);
        builder.setLevels(5);
        builder.setWall(new Wall(Wall.WallType.AERATED_CONCRETE));
        builder.setWindows(new Windows(Windows.WindowFrame.WOOD));
        builder.setAmountWindows(25);
        builder.setRoof(new Roof(Roof.RoofType.MULTI_SLOPE, "wood/tiles"));
        builder.setDoors(new Doors("wood/metal"));
        builder.setPool(new Pool("'Monaco'", 1000));
        builder.setGarage(new Garage(Garage.GarageType.MULTI_GARAGE));
    }

}

