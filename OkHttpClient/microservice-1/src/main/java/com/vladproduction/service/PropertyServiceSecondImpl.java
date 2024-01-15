package com.vladproduction.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("SecondService")
public class PropertyServiceSecondImpl implements PropertyService {


    @Value(value = "${contextApp.profile.property2:This is default value for absent property in 'application.property'}")
    private String value;
    @Override
    public String getPropertyValue() {
        return value;
    }
}
