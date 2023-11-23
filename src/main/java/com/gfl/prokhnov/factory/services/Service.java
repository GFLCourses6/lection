package com.gfl.prokhnov.factory.services;

import com.gfl.prokhnov.factory.Vehicle;
import com.gfl.prokhnov.factory.services.updates.Systems;

public interface Service {
    void update(Vehicle vehicle, Systems systems);
}
