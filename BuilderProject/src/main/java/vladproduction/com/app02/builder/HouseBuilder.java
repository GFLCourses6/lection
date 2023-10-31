package vladproduction.com.app02.builder;

import vladproduction.com.app02.model.*;

public class HouseBuilder implements Builder {

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



    public House getResult(){
        return new House(houseType, levels, wall, windows, amountWindows, roof, doors, pool, garage);
    }


}
