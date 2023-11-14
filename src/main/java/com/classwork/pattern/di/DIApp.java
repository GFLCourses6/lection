package com.classwork.pattern.di;

import java.util.Set;

public class DIApp {
    public static void main(String[] args) {

        ServiceBuildFactory buildFactory = new ServiceBuildFactory();
        Set<Class<?>> services = buildFactory.getServices();

        for (Class<?> service : services) {
            Object createdService = buildFactory.create(service);
            if (createdService != null) {
                System.out.println(createdService.getClass());
            } else {
                System.out.println("Service not found for: " + service);
            }
        }

        for (Class<?> clazz : services) {
            if (!clazz.isInterface()) {
                try {
                    Object service = clazz.getDeclaredConstructor().newInstance();
                    System.out.println("Service class found: " + service);
                } catch (Exception e) {
                    System.err.println(clazz);
                }
            }
        }
    }
}
