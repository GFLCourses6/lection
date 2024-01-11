package com.ua.profile.service;

import com.ua.profile.model.PropertyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("secondService")
@Scope(scopeName = "prototype")
public class PropertyServiceTwo
        implements PropertyService {

    @Override
    public PropertyResponse addProperty(
            String port, String name) {
        return new PropertyResponse("prototype", name, port);
    }
}
