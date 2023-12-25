package com.gfl.factory;

import com.gfl.factory.factory.FurnitureFactory;
import com.gfl.factory.fof.FurnitureFactoryProducer;

public class Client {

    private final FurnitureFactory factory;

    public Client() {
        this.factory = FurnitureFactoryProducer.getFurnitureFactory(true);
    }

    void someOperation() {
        var chair = factory.createChair();
        var table = factory.createTable();
        var shelf = factory.createShelf();

        System.out.println(chair.getPrice());
        System.out.println(table.getWidth());
        System.out.println(shelf.getHeight());
    }
}
