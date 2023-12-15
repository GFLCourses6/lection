package com.ua;

import org.springframework.context.support.GenericApplicationContext;

public class App {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.close();
    }
}
