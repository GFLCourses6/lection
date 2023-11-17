package com.ua.factory.furniture.piece.minimalistic;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.CoffeeTable;

public class MinimalisticCoffeeTable
        extends CoffeeTable {

    private final Dimensions dimensions;

    public MinimalisticCoffeeTable(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    protected int getWidth() {
        return dimensions.getWidth();
    }

    @Override
    protected int getLength() {
        return dimensions.getLength();
    }

    @Override
    public void serveCoffee() {
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }
}
