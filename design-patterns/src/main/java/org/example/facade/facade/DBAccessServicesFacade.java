package org.example.facade.facade;

import org.example.facade.service.DbConnectionService;
import org.example.facade.service.SQLQueriesService;

public class DBAccessServicesFacade implements DBAccessServices {

    private final DbConnectionService dbConnectionService;
    private final SQLQueriesService sqlQueriesService;

    public DBAccessServicesFacade(DbConnectionService dbConnectionService, SQLQueriesService sqlQueriesService) {
        this.dbConnectionService = dbConnectionService;
        this.sqlQueriesService = sqlQueriesService;
    }

    @Override
    public String getUserById(String id) {
        String user = sqlQueriesService.constructSQLSearchById(id);
        return dbConnectionService.invokeSQL(user);
    }
}
