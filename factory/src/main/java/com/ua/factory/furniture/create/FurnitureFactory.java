package com.ua.factory.furniture.create;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.Chair;
import com.ua.factory.furniture.piece.CoffeeTable;
import com.ua.factory.furniture.piece.FurniturePiece;
import com.ua.factory.furniture.piece.Sofa;

public interface FurnitureFactory {
    FurniturePiece createPiece(String piece);

    Sofa createSofa(Dimensions dimensions);

    CoffeeTable createCoffeeTable(Dimensions dimensions);

    Chair createChair(Dimensions dimensions);
}
