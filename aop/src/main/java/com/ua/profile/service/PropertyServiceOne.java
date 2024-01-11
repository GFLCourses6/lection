package com.ua.profile.service;

import com.ua.profile.model.PropertyResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service("firstService")
@Scope(scopeName = "singleton")
public class PropertyServiceOne
        implements PropertyService {

    @Override
    public PropertyResponse addProperty(
            String port, String name) {
        PropertyResponse response = new PropertyResponse("singleton", name, port);
        holder.addProperty(response);
        return response;
    }
}
