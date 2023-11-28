package org.example.di.abstractFactory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
