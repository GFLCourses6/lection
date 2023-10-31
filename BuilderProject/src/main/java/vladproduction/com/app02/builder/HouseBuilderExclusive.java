package vladproduction.com.app02.builder;

import vladproduction.com.app02.model.*;

public class HouseBuilderExclusive implements Builder{

    private HouseType houseType;
    private int levels;
    private Wall wall;
    private Windows windows;
    private int amountWindows;
    private Roof roof;
    private Doors doors;
    private Pool pool;
    private Garage garage;
    @Override
    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    @Override
    public void setLevels(int levels) {
        this.levels = levels;
    }

    @Override
    public void setWall(Wall wall) {
        this.wall = wall;
    }

    @Override
    public void setWindows(Windows windows) {
        this.windows = windows;
    }

    @Override
    public void setAmountWindows(int amountWindows) {
        this.amountWindows = amountWindows;
    }

    @Override
    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    @Override
    public void setDoors(Doors doors) {
        this.doors = doors;
    }


    public void setPool(Pool pool) {
        this.pool = pool;
    }


    public void setGarage(Garage garage) {
        this.garage = garage;
    }



    public void print(){
        StringBuilder builder = new StringBuilder();
        builder.append("Type: ").append(houseType).append("\n");
        builder.append("Levels: ").append(levels).append("\n");
        if(Wall.WallType.BRICK.equals(wall.getWallType())){
            builder.append(String.format("Wall material: %s", Wall.WallType.BRICK)).append("\n");
        }
        if(Wall.WallType.SANDWICH_PANEL.equals(wall.getWallType())){
            builder.append(String.format("Wall material: %s", Wall.WallType.SANDWICH_PANEL)).append("\n");
        }
        if(Wall.WallType.AERATED_CONCRETE.equals(wall.getWallType())){
            builder.append(String.format("Wall material: %s", Wall.WallType.AERATED_CONCRETE)).append("\n");
        }
        builder.append("Roof: ").append(roof).append("\n");
        builder.append("Door: ").append(doors).append("\n");
        if(Windows.WindowFrame.WOOD.equals(windows.getWindowFrame())){
            builder.append(String.format("Window frame: %s", Windows.WindowFrame.WOOD)).append("\n");
        }
        if(Windows.WindowFrame.PLASTIC.equals(windows.getWindowFrame())){
            builder.append(String.format("window frame: %s", Windows.WindowFrame.PLASTIC)).append("\n");
        }
        builder.append("Amount of windows: ").append(amountWindows).append("\n");
        if(pool != null){
            builder.append(String.format("Pool: %s", pool)).append("\n");
        }
        if(garage != null){
            if(Garage.GarageType.ORDINARY.equals(garage.getGarageType())){
                builder.append(String.format("Garage: %s", garage));
            }
            if(Garage.GarageType.BASEMENT_IN.equals(garage.getGarageType())){
                builder.append(String.format("Garage: %s", garage));
            }
            if(Garage.GarageType.MULTI_GARAGE.equals(garage.getGarageType())){
                builder.append(String.format("Garage: %s", garage));
            }
        }
        System.out.println(builder);
    }

}


