package com.gfl.prokhnov.example.patterns.factory;

public interface VehicleFactory {
    Vehicle buildMini();
    Vehicle buildSUV();
    Vehicle buildJeep();

}
