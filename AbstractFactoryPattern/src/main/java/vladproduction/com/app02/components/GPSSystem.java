package vladproduction.com.app02.components;

import java.util.Objects;

public class GPSSystem {

    private String model;

    public GPSSystem(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GPSSystem gpsSystem = (GPSSystem) object;
        return Objects.equals(model, gpsSystem.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "GPSSystem{" +
                "model='" + model + '\'' +
                '}';
    }
}
