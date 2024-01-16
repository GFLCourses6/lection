package ua.chemerys.facade;

import ua.chemerys.service.DbConnectionService;
import ua.chemerys.service.SQLQueriesService;

public class DbAccessServiceFacade implements DbAccessService{

    private SQLQueriesService sqlQueriesService;
    private DbConnectionService dbConnectionService;

    public DbAccessServiceFacade(SQLQueriesService sqlQueriesService, DbConnectionService dbConnectionService) {
        this.sqlQueriesService = sqlQueriesService;
        this.dbConnectionService = dbConnectionService;
    }

    @Override
    public String getUserById(String id) {

        String sql = sqlQueriesService.constructSqlSearchUserById(id);
        return dbConnectionService.invokeSql(sql);
    }
}
