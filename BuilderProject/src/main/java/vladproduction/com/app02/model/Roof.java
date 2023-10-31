package vladproduction.com.app02.model;

public class Roof {

    private final RoofType roofType;
    private final String roofMaterial;

    public Roof(RoofType roofType, String roofMaterial) {
        this.roofType = roofType;
        this.roofMaterial = roofMaterial;
    }

    public RoofType getRoofType() {
        return roofType;
    }

    public String getRoofMaterial() {
        return roofMaterial;
    }

    @Override
    public String toString() {
        return roofType + ", material: " + roofMaterial;

    }

    public enum RoofType {
        FLAT, SPAN_ROOF, MULTI_SLOPE
    }
}
