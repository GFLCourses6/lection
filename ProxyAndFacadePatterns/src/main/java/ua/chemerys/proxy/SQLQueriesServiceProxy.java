package ua.chemerys.proxy;

import ua.chemerys.service.SQLQueriesService;

import java.util.HashMap;
import java.util.Map;

public class SQLQueriesServiceProxy implements SQLQueriesService {

    private final SQLQueriesService sqlQueriesService;

    private static final Map<String, String> CACHE = new HashMap<>();

    public SQLQueriesServiceProxy(SQLQueriesService sqlQueriesService){
        this.sqlQueriesService = sqlQueriesService;
    }
    @Override
    public String constructSqlSearchUserById(String id) {

        //Here you do some additional staff
        System.out.println("User id called = " + id);

        //And here you call real method
        String sql = CACHE.get(id);
        if (sql == null) {
            String realSql = sqlQueriesService.constructSqlSearchUserById(id);
            CACHE.put(id, realSql);
            return realSql;
        }
        return sql;
    }
}
