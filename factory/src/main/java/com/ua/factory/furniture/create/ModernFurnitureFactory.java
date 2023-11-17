package com.ua.factory.furniture.create;

import com.ua.factory.furniture.Dimensions;
import com.ua.factory.furniture.piece.Chair;
import com.ua.factory.furniture.piece.CoffeeTable;
import com.ua.factory.furniture.piece.FurniturePiece;
import com.ua.factory.furniture.piece.Sofa;
import com.ua.factory.furniture.piece.modern.ModernChair;
import com.ua.factory.furniture.piece.modern.ModernCoffeeTable;
import com.ua.factory.furniture.piece.modern.ModernSofa;

public class ModernFurnitureFactory
        implements FurnitureFactory {
    @Override
    public FurniturePiece createPiece(String piece) {

        Dimensions dimensions = new Dimensions();

        return switch (piece) {
            case "Sofa" -> createSofa(dimensions);
            case "Chair" -> createChair(dimensions);
            case "CoffeeTable" -> createCoffeeTable(dimensions);
            default -> throw new IllegalArgumentException(
                    "Invalid furniture piece: " + piece);
        };
    }

    @Override
    public Sofa createSofa(Dimensions dimensions) {
        return new ModernSofa(dimensions);
    }

    @Override
    public CoffeeTable createCoffeeTable(Dimensions dimensions) {
        return new ModernCoffeeTable(dimensions);
    }

    @Override
    public Chair createChair(Dimensions dimensions) {
        return new ModernChair(dimensions);
    }
}
