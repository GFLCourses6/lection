package com.classwork.pattern.facade;

import com.classwork.pattern.facade.action.ActionFacade;
import com.classwork.pattern.facade.service.DbAccessServiceFacade;
import com.classwork.pattern.proxy.service.sql.DbConnectionPostgreSqlService;
import com.classwork.pattern.proxy.service.sql.SqlQueriesServiceGeneric;

public class FacadeApp {
    public static void main(String[] args) {
        ActionFacade facade = new ActionFacade();
        facade.performActions();
        SqlQueriesServiceGeneric sqlQueriesService = new SqlQueriesServiceGeneric();
        DbConnectionPostgreSqlService dbConnectionService =
                new DbConnectionPostgreSqlService();
        DbAccessServiceFacade serviceFacade =
                new DbAccessServiceFacade(sqlQueriesService, dbConnectionService);
        String userById = serviceFacade.getUserById("1");
        System.out.println(userById);
    }
}
