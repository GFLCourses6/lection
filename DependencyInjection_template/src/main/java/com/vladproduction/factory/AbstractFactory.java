package com.vladproduction.factory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz); //as param class<concrete> and return created that class<concrete>
}
