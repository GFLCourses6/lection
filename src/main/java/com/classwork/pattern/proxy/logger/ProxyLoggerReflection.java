package com.classwork.pattern.proxy.logger;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ProxyLoggerReflection implements ProxyLogger {
    private final Map<String, String> cache = new HashMap<>();

    public <T> ProxyLoggerReflection(T t) {
        reflectParams(t);
    }

    private <T> void reflectParams(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object fieldValue = field.get(t);
                if (fieldValue != null) {
                    cache.put(field.getName(), fieldValue.toString());
                }
            } catch (IllegalAccessException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void print() {
        System.out.println(cache);
    }
}