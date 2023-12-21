package com.ua.profile.service;

import com.ua.profile.model.PropertyField;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("SecondService")
public class PropertyServiceTwo
        implements PropertyService {

    @Value(value = "${test.property}")
    private String profile;

    @Value(value = "${server.port}")
    private String port;

    @Override
    public PropertyField getProperty() {
        return new PropertyField(profile, port);
    }
}
