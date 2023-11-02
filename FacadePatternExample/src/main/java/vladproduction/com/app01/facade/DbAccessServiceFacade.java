package vladproduction.com.app01.facade;

import vladproduction.com.app01.service.DbConnectionService;
import vladproduction.com.app01.service.SQLService;

public class DbAccessServiceFacade implements DbAccessService {

    private final SQLService sqlService;
    private final DbConnectionService dbConnectionService;

    public DbAccessServiceFacade(SQLService sqlService, DbConnectionService dbConnectionService) {
        this.sqlService = sqlService;
        this.dbConnectionService = dbConnectionService;
    }

    @Override
    public String getUserById(String id) {
        String userById = sqlService.constructSearcherUserById(id);
        return dbConnectionService.invokeSql(userById);
    }
}
