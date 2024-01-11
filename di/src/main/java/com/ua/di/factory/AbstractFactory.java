package com.ua.di.factory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
