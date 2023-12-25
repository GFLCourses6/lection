package com.gfl.factory.factory;

import com.gfl.factory.model.Chair;
import com.gfl.factory.model.Shelf;
import com.gfl.factory.model.Table;
import com.gfl.factory.model.futuristic.FuturisticChair;
import com.gfl.factory.model.futuristic.FuturisticShelf;
import com.gfl.factory.model.futuristic.FuturisticTable;

public class FuturisticFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new FuturisticChair();
    }

    @Override
    public Table createTable() {
        return new FuturisticTable();
    }

    @Override
    public Shelf createShelf() {
        return new FuturisticShelf();
    }
}
