package vladproduction.com.app02.model;

public class House {

    private final HouseType houseType;
    private final int levels;
    private final Wall wall;
    private final Windows windows;
    private final int amountWindows;
    private final Roof roof;
    private final Doors doors;
    private Pool pool;
    private  Garage garage;

    public House(HouseType houseType, int levels, Wall wall, Windows windows, int amountWindows, Roof roof,
                 Doors doors, Pool pool, Garage garage) {
        this.houseType = houseType;
        this.levels = levels;
        this.wall = wall;
        this.windows = windows;
        this.amountWindows = amountWindows;
        this.roof = roof;
        this.doors = doors;
        this.pool = pool;
        this.garage = garage;
    }

    public HouseType getHouseType() {return houseType;}

    public int getLevels() {return levels;}

    public Wall getWall() {return wall;}

    public Windows getWindows() {return windows;}

    public int getAmountWindows() {return amountWindows;}

    public Roof getRoof() {return roof;}

    public Doors getDoors() {
        return doors;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "House: "
                + houseType +"\n"+
                "levels=" + levels +"\n"+
                "wall=" + wall +"\n"+
                "windows=" + windows +"\n"+
                "amountWindows=" + amountWindows +"\n"+
                "roof=" + roof +"\n"+
                "doors=" + doors +"\n"+
                "pool=" + pool +"\n"+
                "garage=" + garage +"\n";
    }
}
