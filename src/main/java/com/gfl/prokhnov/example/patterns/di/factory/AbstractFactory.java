package com.gfl.prokhnov.example.patterns.di.factory;

public interface AbstractFactory {
    <T> T create(Class<T> tClass);
}
