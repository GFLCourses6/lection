package com.gfl.prokhnov.di.factory;

import com.gfl.prokhnov.di.service.DbIntegrationService;
import com.gfl.prokhnov.di.service.FileIntegrationService;
import com.gfl.prokhnov.di.service.FileIntegrationServiceImpl;
import com.gfl.prokhnov.di.service.StringIntegrationService;
import com.gfl.prokhnov.di.service.StringIntegrationServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DIFactory implements AbstractFactory {

    private final static Map<Class, Object> context = new HashMap<>();

    @Override
    public <T> T create(Class<T> clazz) {
        if (StringIntegrationService.class.isAssignableFrom(clazz)) {
            return (T) (new StringIntegrationServiceImpl());
        }

/*        if (FileIntegrationService.class.isAssignableFrom(tClass)) {
            return (T) (new StringIntegrationServiceImpl());
        }*/

        if (FileIntegrationService.class.isAssignableFrom(clazz)) {
            // get impl from context
            Object o = context.get(clazz);
            if (o == null) {
                FileIntegrationService fileIntegrationService = new FileIntegrationServiceImpl();
                context.put(clazz, fileIntegrationService);
                return (T) fileIntegrationService;
            }
            return (T) o;
        }

        if (DbIntegrationService.class.isAssignableFrom(clazz)){
            return (T) getProxy(clazz);
        }

        return null;
    }

    private Object getProxy(Class clazz) {
        return Proxy
                .newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().startsWith("get")) {
                            String param = (String) args[0];
                            String tableNameAndParam = method.getName().substring(3);
                            String[] tableNameParameter = tableNameAndParam.split("By");
                            String sql = String.format("SELECT * FROM %s where %s = %s",
                                    tableNameParameter[0].toLowerCase(),
                                    tableNameParameter[1].toLowerCase(),
                                    param);
                            System.out.println(sql);
                            return sql;
                        }
                        return null;
                    }
                });
    }
}
