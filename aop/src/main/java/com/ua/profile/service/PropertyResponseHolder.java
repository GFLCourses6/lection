package com.ua.profile.service;

import com.ua.profile.model.PropertyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class PropertyResponseHolder {

    private final Queue<PropertyResponse> properties;

    public PropertyResponseHolder(
            @Value("${test.property:default}") String profile,
            @Value("${server.port:8080}") String port) {
        this.properties = new LinkedBlockingQueue<>();
        init(profile, port);
    }

    private void init(
            String profile,
            String port) {
        properties.add(new PropertyResponse(profile, "holder", port));
    }

    public void addProperty(PropertyResponse propertyResponse) {
        properties.offer(propertyResponse);
    }

    public PropertyResponse pollProperty() {
        if (isEmpty()) {
            init("default", "8080");
        }
        return properties.poll();
    }

    public boolean isEmpty() {
        return properties.isEmpty();
    }

    public Queue<PropertyResponse> getProperties() {
        return properties;
    }
}
