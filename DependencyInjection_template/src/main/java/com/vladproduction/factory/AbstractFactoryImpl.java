package com.vladproduction.factory;

import com.vladproduction.services.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class AbstractFactoryImpl implements AbstractFactory {

    private static final Map<Class<?>, Object> context = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(Class<T> clazz) {
        //string
        if (StringIntegrationService.class.isAssignableFrom(clazz)) {
            return (T) (new StringIntegrationServiceImpl());
        }

        /*//file=variant#1
        if(FileIntegrationService.class.isAssignableFrom(clazz)){ //not singleton
            return (T)(new FileIntegrationServiceImpl());
        }
        //file=variant#2
        if (FileIntegrationService.class.isAssignableFrom(clazz)) { //singleton - experimental
            if (context.get(clazz) == null) {
                FileIntegrationService fileService = new FileIntegrationServiceImpl();
                context.put(clazz, fileService);
                return (T) fileService;
            }
        }*/
        //file=variant#3: create singleton object
        if (FileIntegrationService.class.isAssignableFrom(clazz)) {
            Object object = context.get(clazz);
            if (object == null) {
                FileIntegrationService fileIntegrationService = new FileIntegrationServiceImpl();
                context.put(clazz, fileIntegrationService);
                return (T) fileIntegrationService;
            }
            return (T) object;
        }

        //dataBase
        if (DBIntegrationService.class.isAssignableFrom(clazz)) {
            //return (T)getProxy(clazz);
            //return (T)getProxyLambda(clazz);
            return (T) getProxyHandle(clazz);
        }

        return null;
    }

    private Object getProxy(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //getBookByYearAndAuthor
                if (method.getName().startsWith("get") && method.getName().contains("And")) {
                    String param0 = (String) args[0];
                    String param1 = (String) args[1];
                    String tableNameAndParameters = method.getName().substring(3);
                    String[] tableNameParameters = tableNameAndParameters.split("By");  //Book[0], YearAndAuthor[1]
                    String[] parameters = tableNameParameters[1].split("And"); //Year[0], Author[1]

                    String sqlAnd = String
                            .format("SELECT * FROM %s where %s = %s and %s = %s",
                                    tableNameParameters[0].toLowerCase(),
                                    parameters[0].toLowerCase(), param0,
                                    parameters[1].toLowerCase(), param1);

                    System.out.println(sqlAnd);
                    return sqlAnd;
                }

                //getBookByYearOrAuthor
                if (method.getName().startsWith("get") && method.getName().contains("Or")) {
                    String param0 = (String) args[0];
                    String param1 = (String) args[1];
                    String tableNameAndParameters = method.getName().substring(3);
                    String[] tableNameParameters = tableNameAndParameters.split("By");  //Book[0], YearOrAuthor[1]
                    String[] parameters = tableNameParameters[1].split("Or"); //Year[0], Author[1]

                    String sqlOr = String
                            .format("SELECT * FROM %s where %s = %s or %s = %s",
                                    tableNameParameters[0].toLowerCase(),
                                    parameters[0].toLowerCase(), param0,
                                    parameters[1].toLowerCase(), param1);

                    System.out.println(sqlOr);
                    return sqlOr;
                }

                //getUserById
                if (method.getName().startsWith("get")) {
                    String param = (String) args[0];
                    String tableNameAndParam = method.getName().substring(3); //table name and param id: 'UserById'
                    String[] tableNameParameter = tableNameAndParam.split("By");  //User, id
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

    private Object getProxyLambda(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            if (method.getName().startsWith("get") && method.getName().contains("And")) {
                String param0 = (String) args[0];
                String param1 = (String) args[1];
                String tableNameAndParameters = method.getName().substring(3);
                String[] tableNameParameters = tableNameAndParameters.split("By");  //Book[0], YearAndAuthor[1]
                String[] parameters = tableNameParameters[1].split("And"); //Year[0], Author[1]

                String sqlAnd = String
                        .format("SELECT * FROM %s where %s = %s and %s = %s",
                                tableNameParameters[0].toLowerCase(),
                                parameters[0].toLowerCase(), param0,
                                parameters[1].toLowerCase(), param1);

                System.out.println(sqlAnd);
                return sqlAnd;
            }
            if (method.getName().startsWith("get") && method.getName().contains("Or")) {
                String param0 = (String) args[0];
                String param1 = (String) args[1];
                String tableNameAndParameters = method.getName().substring(3);
                String[] tableNameParameters = tableNameAndParameters.split("By");  //Book[0], YearAndAuthor[1]
                String[] parameters = tableNameParameters[1].split("Or"); //Year[0], Author[1]

                String sqlOr = String
                        .format("SELECT * FROM %s where %s = %s or %s = %s",
                                tableNameParameters[0].toLowerCase(),
                                parameters[0].toLowerCase(), param0,
                                parameters[1].toLowerCase(), param1);

                System.out.println(sqlOr);
                return sqlOr;
            }
            if (method.getName().startsWith("get")) {
                String param = (String) args[0];
                String tableNameAndParam = method.getName().substring(3); //table name and param id: 'UserById'
                String[] tableNameParameter = tableNameAndParam.split("By");  //User, id
                String sql = String.format("SELECT * FROM %s where %s = %s",
                        tableNameParameter[0].toLowerCase(),
                        tableNameParameter[1].toLowerCase(),
                        param);
                System.out.println(sql);
                return sql;
            }
            return null;
        });
    }

    private <T> Object getProxyHandle(Class<T> clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {

                if (method.getName().startsWith("get")) {
                    return behaviourOfGet(method, args);
                }
                return null;
            }

            private Object behaviourOfGet(Method method, Object[] args) {

                String[] tableNameChooseParams = method.getName().substring(3).split("By");
                String tableBDName = tableNameChooseParams[0];
                String[] selectorVariant = tableNameChooseParams[1].split("(And|Or)");
                if (selectorVariant.length > 0 && args != null && args.length >= selectorVariant.length) {
                    return getSqlTwo(args, tableBDName, selectorVariant, tableNameChooseParams);
                }
                return null;
            }

            //variant#1-getSqlOne
            private static String getSqlOne(Object[] args, String tableBDName, String[] selectorVariant, String[] tableNameChooseParams) {

                StringBuffer sqlQueryBuilder = new StringBuffer(String.format("SELECT * FROM %s WHERE ", tableBDName.toLowerCase()));

                for (int i = 0; i < selectorVariant.length; i++) {
                    sqlQueryBuilder.append(String.format("%s = '%s'", selectorVariant[i].toLowerCase(), args[i]));
                    if (i < selectorVariant.length - 1) {
                        if (tableNameChooseParams[1].contains("And")) {
                            sqlQueryBuilder.append(" AND ");
                        } else if (tableNameChooseParams[1].contains("Or")) {
                            sqlQueryBuilder.append(" OR ");
                        }
                    }
                }
                String result = sqlQueryBuilder.toString();
                System.out.println(result);
                return result;
            }

            //variant#2-getSqlTwo
            private static String getSqlTwo(Object[] args, String tableBDName,
                                            String[] selectorVariant, String[] tableNameChooseParams) {

                StringBuffer sqlQueryBuilder = new StringBuffer( String.format("SELECT * FROM %s WHERE ",
                        tableBDName.toLowerCase()));

                for (int i = 0; i < selectorVariant.length; i++) {
                    sqlQueryBuilder.append(String.format("%s = '%s'", selectorVariant[i].toLowerCase(), args[i]));

                    if (i < selectorVariant.length - 1) {
                        boolean b = tableNameChooseParams[1].contains("And");
                        if (b) {
                            sqlQueryBuilder.append(" AND ");
                        } else  {
                            sqlQueryBuilder.append(" OR ");
                        }
                    }
                }
                String result = sqlQueryBuilder.toString();
                System.out.println(result);
                return result;
            }
        });
    }


}
