package com.gfl.factory.factory;

import com.gfl.factory.model.Chair;
import com.gfl.factory.model.Shelf;
import com.gfl.factory.model.Table;

public interface FurnitureFactory {

    Chair createChair();
    Table createTable();
    Shelf createShelf();
}
