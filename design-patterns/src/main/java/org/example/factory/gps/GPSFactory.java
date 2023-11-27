package org.example.factory.gps;

public interface GPSFactory<T> {
    T createHighEndGpsSystem();

    T createLowEndGpsSystem();

}
