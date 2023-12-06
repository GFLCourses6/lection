package com.vladproduction.convertor;

import com.vladproduction.model.Scenario;

public interface ScenarioConvertor {

    String fromScenario(Scenario scenario);

    Scenario toScenario(String content);
}
