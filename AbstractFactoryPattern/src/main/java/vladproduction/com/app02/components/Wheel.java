package vladproduction.com.app02.components;

import java.util.Objects;

public class Wheel {

    private String brand;
    private int size;

    public Wheel(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Wheel wheel = (Wheel) object;
        return size == wheel.size && Objects.equals(brand, wheel.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, size);
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}
