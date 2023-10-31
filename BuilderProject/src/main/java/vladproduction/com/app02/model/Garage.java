package vladproduction.com.app02.model;

public class Garage {

    private final GarageType garageType;

    public Garage(GarageType garageType) {
        this.garageType = garageType;
    }

    public GarageType getGarageType() {
        return garageType;
    }

    @Override
    public String toString() {
        return "" + garageType;

    }

    public enum GarageType {
        ORDINARY, BASEMENT_IN, MULTI_GARAGE
    }
}
