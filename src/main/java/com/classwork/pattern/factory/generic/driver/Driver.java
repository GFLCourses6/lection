package com.classwork.pattern.factory.generic.driver;

public interface Driver<T> {

    Driver<T> create();
}
