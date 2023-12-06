package com.vladproduction.convertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.model.Scenario;

public class JsonScenarioConvertor implements ScenarioConvertor {

    private ObjectMapper om = new ObjectMapper();

    @Override
    public String fromScenario(Scenario scenario) {
        try {
            return om.writeValueAsString(scenario);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Scenario toScenario(String content) {
        try {
            return om.readValue(content, Scenario.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
