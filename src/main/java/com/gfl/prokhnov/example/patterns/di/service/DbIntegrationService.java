package com.gfl.prokhnov.example.patterns.di.service;

public interface DbIntegrationService {
    String getUserById(String id);
    String getCityByCapital(String capital);
}
