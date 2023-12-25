package com.gfl.factory.fof;

import com.gfl.factory.factory.FurnitureFactory;
import com.gfl.factory.factory.FuturisticFurnitureFactory;
import com.gfl.factory.factory.ModernFurnitureFactory;

public class FurnitureFactoryProducer {

    public static FurnitureFactory getFurnitureFactory(boolean isModern) {
        if (isModern) {
            return new ModernFurnitureFactory();
        } else {
            return new FuturisticFurnitureFactory();
        }
    }
}
