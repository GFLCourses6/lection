package com.ua.factory.furniture.piece;

import com.ua.factory.furniture.Dimensions;

public abstract class Chair
        implements FurniturePiece {

    protected Dimensions dimensions;

    protected String getColor() {
        return dimensions.getColor();
    }

    public void sitOn() {
        dimensions.sitOn();
        System.out.println("sitOn");
    }
}
