package com.ua.factory.furniture;

import com.ua.factory.furniture.create.FurnitureFactory;
import com.ua.factory.furniture.piece.Chair;
import com.ua.factory.furniture.piece.CoffeeTable;
import com.ua.factory.furniture.piece.Sofa;

public class Client {

    private final Chair chair;
    private final Sofa sofa;
    private final CoffeeTable coffeeTable;
    Dimensions dimensions = new Dimensions();

    public Client(FurnitureFactory factory) {
        this.chair = factory.createChair(dimensions);
        this.sofa = factory.createSofa(dimensions);
        this.coffeeTable = factory.createCoffeeTable(dimensions);
    }

    void useFurniture() {
        chair.sitOn();
        sofa.layOn();
        coffeeTable.serveCoffee();
    }
}
