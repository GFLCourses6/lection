package com.ua.factory.furniture.piece;

import com.ua.factory.furniture.Dimensions;

public abstract class Sofa
        implements FurniturePiece {

    protected Dimensions dimensions;

    protected String getMaterial() {
        return dimensions.getMaterial();
    }

    public void layOn(){
        dimensions.layOn();
        System.out.println("layOn");
    }
}
