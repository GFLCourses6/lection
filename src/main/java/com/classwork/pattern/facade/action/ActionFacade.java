package com.classwork.pattern.facade.action;

public class ActionFacade {
    public void performActions() {
        int count = 0;
        Singleton actionFile = SingletonFile.getInstance(count);
        Singleton actionConsole = SingletonConsole.getInstance(actionFile.action());
        Singleton actionDataBase = SingletonDataBase.getInstance(actionConsole.action());
        actionDataBase.action();
    }
}
