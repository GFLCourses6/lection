package com.classwork.pattern.facade.service;

import com.classwork.pattern.proxy.service.sql.DbConnectionService;
import com.classwork.pattern.proxy.service.sql.SqlQueriesService;

public class DbAccessServiceFacade
        implements DbAccessService {
    private final SqlQueriesService sqlQueriesService;

    private final DbConnectionService dbConnectionService;

    public DbAccessServiceFacade(
            SqlQueriesService sqlQueriesService,
            DbConnectionService dbConnectionService) {
        this.sqlQueriesService = sqlQueriesService;
        this.dbConnectionService = dbConnectionService;
    }

    @Override
    public String getUserById(String id) {
        String sql = sqlQueriesService.constructSqlSearchUserById(id);
        return dbConnectionService.invoke(sql);
    }
}
