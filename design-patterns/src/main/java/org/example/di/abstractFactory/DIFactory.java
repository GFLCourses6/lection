package org.example.di.abstractFactory;

import org.example.di.service.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DIFactory implements AbstractFactory{
    private static final Map<Class, Object> context = new HashMap(); // hashmap guarantees the key uniqueness

    @Override // get class type and return instance - it is IoC abstract factory
    public <T> T create(Class<T> clazz) { // versatilite unit to create objects
        if(StringIntegrationService.class.isAssignableFrom(clazz)){
            return (T)(new StringIntegrationServiceImpl());
        }
        // керуємо життєвим циклом so make singleton
        if(FileIntegrationService.class.isAssignableFrom(clazz)){
            Object object = context.get(clazz);
            if(object == null){
                FileIntegrationService service = new FileIntegrationServiceImpl();
                context.put(clazz, service);
                return (T) service;
            }
            return (T) object;
        }
//        return null;

        if(DBIntegrationService.class.isAssignableFrom(clazz)){
            return (T)getProxy(clazz);
        }
        return null;
    }

    private Object getProxy(Class clazz){ // here we built implementation for our interface method
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() { // new InvocationHandler - say how proxy will construct onject
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // method which in interface
                if(method.getName().startsWith("get") && method.getName().contains("And")){
                    String param0 = (String) args[0];
                    String param1 = (String) args[1];
                    String tableNameAndParameter = method.getName().substring(3); // Book, YearAndAuthor
                    String[] tableNameParameter = tableNameAndParameter.split("By"); // Book, YearAndAuthor
                    String[] parameters = tableNameParameter[1].split("And"); // Year, author
                    String sql = String.format("SELECT * FROM %s where %s = %s and %s = %s",
                            tableNameParameter[0].toLowerCase(), parameters[0].toLowerCase(), param0,
                            parameters[1].toLowerCase(), param1);
                    System.out.println(sql);
                    return sql;
                }

                if(method.getName().startsWith("get")){
                    String param = (String)args[0];
                    String tableNameAndParameter = method.getName().substring(3); // UserById
                    String[] tableNameParameter = tableNameAndParameter.split("By"); // User, Id
                    String sql = String.format("SELECT * FROM %s where %s = %s", tableNameParameter[0].toLowerCase(), tableNameParameter[1].toLowerCase(), param);
                    System.out.println(sql);
                    return sql;
                }
                return null;
            }
        });
    }
}
