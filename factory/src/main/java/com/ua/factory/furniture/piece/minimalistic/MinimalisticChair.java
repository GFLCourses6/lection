package com.ua.factory.furniture.piece.minimalistic;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.Chair;

public class MinimalisticChair
        extends Chair {

    public MinimalisticChair(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }
}
