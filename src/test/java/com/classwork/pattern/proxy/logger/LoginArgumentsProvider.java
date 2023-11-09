package com.classwork.pattern.proxy.logger;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class LoginArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of("Jack", "Sparrow", 100L),
                Arguments.of("John", "Turner", 200L),
                Arguments.of("Jane", "Swan", 300L));
    }
}