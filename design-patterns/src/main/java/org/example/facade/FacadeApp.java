package org.example.facade;

import org.example.facade.facade.DBAccessServices;
import org.example.facade.facade.DBAccessServicesFacade;
import org.example.facade.service.DBConnectionServiceMySQL;
import org.example.facade.service.DbConnectionService;
import org.example.facade.service.SQLQueriesService;
import org.example.facade.service.SQLQueriesServiceGeneric;

public class FacadeApp {
    public static void main(String[] args) {
        DbConnectionService dbConnectionService = new DBConnectionServiceMySQL();
        SQLQueriesService sqlQueriesService = new SQLQueriesServiceGeneric();
        DBAccessServices facade = new DBAccessServicesFacade(dbConnectionService, sqlQueriesService);
        String userById = facade.getUserById("1");
        System.out.println(userById);

    }
}