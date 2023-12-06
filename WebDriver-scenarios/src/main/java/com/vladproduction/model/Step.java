package com.vladproduction.model;

public class Step {

    private int id;
    private FindElementType findElementType;
    private String findElementValue;
    private ActionType actionType;

    public FindElementType getFindElementType() {
        return findElementType;
    }

    public void setFindElementType(FindElementType findElementType) {
        this.findElementType = findElementType;
    }

    public String getFindElementValue() {
        return findElementValue;
    }

    public void setFindElementValue(String findElementValue) {
        this.findElementValue = findElementValue;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
