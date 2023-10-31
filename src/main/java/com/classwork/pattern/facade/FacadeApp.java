package com.classwork.pattern.facade;

import com.classwork.pattern.facade.action.ActionFacade;

public class FacadeApp {
    public static void main(String[] args) {
        ActionFacade facade = new ActionFacade();
        facade.performActions();
    }
}
