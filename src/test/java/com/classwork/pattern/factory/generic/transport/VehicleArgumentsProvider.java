package com.classwork.pattern.factory.generic.transport;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

class VehicleArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of("Plane", Plane.class),
                Arguments.of("Ship", Ship.class),
                Arguments.of("Motorcycle", MotorCycle.class));
    }
}
