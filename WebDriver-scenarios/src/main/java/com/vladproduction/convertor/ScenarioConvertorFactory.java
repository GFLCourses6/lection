package com.vladproduction.convertor;

public class ScenarioConvertorFactory {

    public static ScenarioConvertor getScenarioConvertor(ScenarioConvertorType scenarioConvertorType){

        switch (scenarioConvertorType){
            case JSON : return new JsonScenarioConvertor();
            default : throw new IllegalArgumentException("incorrect data type");
        }

    }
}
