package com.ua.factory.furniture.piece.modern;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.CoffeeTable;

public class ModernCoffeeTable
        extends CoffeeTable {
    public ModernCoffeeTable(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }
}
