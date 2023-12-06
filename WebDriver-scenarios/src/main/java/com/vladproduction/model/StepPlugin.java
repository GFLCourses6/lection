package com.vladproduction.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepPlugin {

    public void execute(WebDriver driver, Step step){
        switch (step.getActionType()){
            case CLICK : executeClick(driver, step);break;
            case SET_VALUE : executeSetValue(driver, step);break;
            case GET_RESULT : executeGetResult(driver, step); break;
            default : throw new IllegalArgumentException("action is not legal");
        }

    }

    private void executeClick(WebDriver driver, Step step){

        switch (step.getFindElementType()){
            case ID : executeClickById(driver, step); break;
            case CSS: executeClickByCss(driver, step); break;
            case XPATH: executeClickByXPath(driver, step); break;
            default : throw new IllegalArgumentException("action is not legal");

        }



    }
    private void executeSetValue(WebDriver driver, Step step){

    }
    private void executeGetResult(WebDriver driver, Step step){

    }

    private void executeClickById(WebDriver driver, Step step){
        var element = driver.findElement(By.id(step.getFindElementValue()));
        element.click();

    }
    private void executeClickByCss(WebDriver driver, Step step){
        var element = driver.findElement(By.cssSelector(step.getFindElementValue()));
        element.click();

    }
    private void executeClickByXPath(WebDriver driver, Step step){
        var element = driver.findElement(By.xpath(step.getFindElementValue()));
        element.click();

    }
}
