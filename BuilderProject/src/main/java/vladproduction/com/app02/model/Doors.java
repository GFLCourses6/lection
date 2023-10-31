package vladproduction.com.app02.model;

public class Doors {

    private final String doorMaterial;

    public Doors(String doorMaterial) {
        this.doorMaterial = doorMaterial;
    }

    public String getDoorMaterial() {
        return doorMaterial;
    }

    @Override
    public String toString() {
        return doorMaterial ;

    }
}
