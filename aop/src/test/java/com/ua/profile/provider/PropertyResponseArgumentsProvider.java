package com.ua.profile.provider;

import com.ua.profile.model.PropertyResponse;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class PropertyResponseArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Queue<PropertyResponse> responses = new LinkedList<>();
        responses.add(new PropertyResponse("dev", "singleton", "8080"));
        responses.add(new PropertyResponse("prod", "prototype", "8081"));
        return Stream.of(Arguments.of(responses));
    }
}