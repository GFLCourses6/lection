package com.gfl.prokhnov.example.patterns.factory.services;

import com.gfl.prokhnov.example.patterns.factory.Vehicle;
import com.gfl.prokhnov.example.patterns.factory.services.updates.Systems;

public interface Service {
    void update(Vehicle vehicle, Systems systems);
}
