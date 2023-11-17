package com.ua.factory.furniture.piece;

import com.ua.factory.furniture.Dimensions;

public abstract class CoffeeTable
        implements FurniturePiece {

    protected Dimensions dimensions;

    protected int getWidth() {
        return dimensions.getWidth();
    }

    protected int getLength() {
        return dimensions.getLength();
    }

    public void serveCoffee() {
        dimensions.sitOn();
        System.out.println("serveCoffee");
    }
}
