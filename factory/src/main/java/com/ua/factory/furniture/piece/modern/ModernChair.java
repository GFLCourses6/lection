package com.ua.factory.furniture.piece.modern;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.Chair;

public class ModernChair
        extends Chair {
    public ModernChair(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }
}
