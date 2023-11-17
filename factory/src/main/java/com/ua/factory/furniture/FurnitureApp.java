package com.ua.factory.furniture;

import com.ua.factory.furniture.create.FurnitureFactory;
import com.ua.factory.furniture.create.ModernFurnitureFactory;

public class FurnitureApp {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Client client = new Client(factory);
        client.useFurniture();
    }
}
