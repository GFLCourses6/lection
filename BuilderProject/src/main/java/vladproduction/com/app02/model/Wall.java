package vladproduction.com.app02.model;

public class Wall {

    private final WallType wallType;

    public Wall(WallType wallType) {
        this.wallType = wallType;
    }

    public WallType getWallType() {
        return wallType;
    }

    @Override
    public String toString() {
        return "" + wallType;
    }

    public enum WallType {
        BRICK, AERATED_CONCRETE, SANDWICH_PANEL

    }
}


