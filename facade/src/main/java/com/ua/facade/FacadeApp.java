package com.ua.facade;

import com.ua.facade.action.ActionFacade;
import com.ua.facade.service.DbAccessService;
import com.ua.facade.service.DbAccessServiceFacade;
import com.ua.facade.service.DbConnectionPostgreSqlService;
import com.ua.facade.service.DbConnectionService;
import com.ua.sql.SqlQueriesService;
import com.ua.sql.SqlQueriesServiceGeneric;

public class FacadeApp {
    public static void main(String[] args) {
        ActionFacade facade = new ActionFacade();
        facade.performActions();
        SqlQueriesService serviceGeneric = new SqlQueriesServiceGeneric();
        DbConnectionService sqlService = new DbConnectionPostgreSqlService();
        DbAccessService serviceFacade =
                new DbAccessServiceFacade(serviceGeneric, sqlService);
        String userById = serviceFacade.getUserById("1");
        System.out.println(userById);
    }
}
