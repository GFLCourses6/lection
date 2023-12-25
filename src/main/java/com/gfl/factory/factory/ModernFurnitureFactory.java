package com.gfl.factory.factory;

import com.gfl.factory.model.Chair;
import com.gfl.factory.model.Shelf;
import com.gfl.factory.model.Table;
import com.gfl.factory.model.modern.ModernChair;
import com.gfl.factory.model.modern.ModernShelf;
import com.gfl.factory.model.modern.ModernTable;

public class ModernFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Shelf createShelf() {
        return new ModernShelf();
    }
}
