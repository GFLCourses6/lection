package com.vladproduction;

import com.vladproduction.convertor.ScenarioConvertor;
import com.vladproduction.convertor.ScenarioConvertorFactory;
import com.vladproduction.model.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static com.vladproduction.convertor.ScenarioConvertorType.JSON;
import static com.vladproduction.model.ActionType.*;
import static com.vladproduction.model.FindElementType.*;

public class MainApp2 {
    public static void main(String[] args) {

        ScenarioConvertor scenarioConvertor = ScenarioConvertorFactory.getScenarioConvertor(JSON);
        String fromScenario = scenarioConvertor.fromScenario(initScenario());
        System.out.println("fromScenario = " + fromScenario);

    }

    private static Scenario initScenario(){
        Scenario scenario = new Scenario();
        scenario.setName("scenario-1");
        scenario.setStartPage("https://google.com");
        List<Step> steps1 = new ArrayList<>();
        scenario.setSteps(steps1);


        Step stepA = new Step();
        stepA.setActionType(CLICK);
        stepA.setFindElementType(ID);
        stepA.setFindElementValue("APjFqb");

        Step stepB = new Step();
        stepB.setActionType(CLICK);
        stepB.setFindElementType(ID);
        stepB.setFindElementValue("APjFqb");

        Step stepC = new Step();
        stepC.setActionType(CLICK);
        stepC.setFindElementType(ID);
        stepC.setFindElementValue("APjFqb");

        steps1.add(stepA);
        steps1.add(stepB);
        steps1.add(stepC);

        return scenario;

    }
}
