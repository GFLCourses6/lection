package com.classwork.pattern.di;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
