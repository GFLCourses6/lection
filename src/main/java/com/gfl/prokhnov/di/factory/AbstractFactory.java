package com.gfl.prokhnov.di.factory;

public interface AbstractFactory {
    <T> T create(Class<T> tClass);
}
