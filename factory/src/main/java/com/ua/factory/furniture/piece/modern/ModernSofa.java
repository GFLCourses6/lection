package com.ua.factory.furniture.piece.modern;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.Sofa;

public class ModernSofa
        extends Sofa {

    public ModernSofa(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }
}
