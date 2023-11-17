package com.ua.factory.furniture.piece.minimalistic;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.Sofa;

public class MinimalisticSofa
        extends Sofa {

    public MinimalisticSofa(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }
}
