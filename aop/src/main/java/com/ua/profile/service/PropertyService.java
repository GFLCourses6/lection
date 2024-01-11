package com.ua.profile.service;

import com.ua.profile.model.PropertyResponse;

import java.util.Queue;

public interface PropertyService {
    PropertyResponseHolder holder = new PropertyResponseHolder( "default", "8080");

    default PropertyResponse pollProperty() {
        return holder.pollProperty();
    }
    default Queue<PropertyResponse> getProperties() {
        return holder.getProperties();
    }

    PropertyResponse addProperty(String port, String name);
}
