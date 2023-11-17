package com.ua.factory.furniture;

public class Dimensions {

    private int width;
    private int length;
    private String color;
    private String material;
    private boolean sit;
    private boolean lay;

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public void sitOn() {
        this.sit = true;
    }

    public void layOn() {
        this.lay = true;
    }
}
