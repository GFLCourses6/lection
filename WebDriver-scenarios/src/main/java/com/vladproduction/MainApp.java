package com.vladproduction;

import com.vladproduction.convertor.ScenarioConvertor;
import com.vladproduction.convertor.ScenarioConvertorFactory;
import com.vladproduction.convertor.ScenarioConvertorType;
import com.vladproduction.model.Scenario;
import com.vladproduction.model.Step;
import com.vladproduction.model.StepPlugin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.vladproduction.convertor.ScenarioConvertorType.*;

public class MainApp {
    public static void main(String[] args) {

        String jsonTest = "{\n" +
                "  \"steps\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"findElementType\": \"ID\",\n" +
                "      \"findElementValue\": \"APjFqb\",\n" +
                "      \"actionType\": \"CLICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"findElementType\": \"ID\",\n" +
                "      \"findElementValue\": \"APjFqb\",\n" +
                "      \"actionType\": \"CLICK\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"findElementType\": \"ID\",\n" +
                "      \"findElementValue\": \"APjFqb\",\n" +
                "      \"actionType\": \"CLICK\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"scenario-1\",\n" +
                "  \"startPage\": \"https://google.com\"\n" +
                "}";

        ScenarioConvertor scenarioConvertor = ScenarioConvertorFactory.getScenarioConvertor(JSON);
        Scenario scenario = scenarioConvertor.toScenario(jsonTest);
        String scenarioName = scenario.getName();
        System.out.println("scenarioName = " + scenarioName);

        List<Step> stepListJsonTest = scenario.getSteps();
        int sizeJsonSteps = stepListJsonTest.size();
        System.out.println("sizeJsonSteps = " + sizeJsonSteps);

        String startPage = scenario.getStartPage();

        WebDriver driver = new ChromeDriver();
        driver.get(startPage);

        StepPlugin stepPlugin = new StepPlugin();


        for (Step step: stepListJsonTest) {
            System.out.println("before execution step: " + step.getId());
            stepPlugin.execute(driver, step);
            System.out.println("after execution step: " + step.getId());
        }
        System.out.println("all steps are completed");
        driver.quit();
    }
}
