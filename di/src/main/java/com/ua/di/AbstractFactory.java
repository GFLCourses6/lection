package com.ua.di;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
