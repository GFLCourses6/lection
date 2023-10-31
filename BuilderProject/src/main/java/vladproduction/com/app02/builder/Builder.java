package vladproduction.com.app02.builder;

import vladproduction.com.app02.model.*;

public interface Builder {

    void setHouseType(HouseType houseType);
    void setLevels(int levels);
    void setWall(Wall wall);
    void setWindows(Windows windows);
    void setAmountWindows(int amountWindows);
    void setRoof(Roof roof);
    void setDoors(Doors doors);

}

