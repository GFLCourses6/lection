package org.example.proxy;

import java.util.HashMap;
import java.util.Map;

public class SQLQueriesServiceProxy implements SQLQueryService{
    private final SQLQueryService sqlQueryService;
    private static final Map<String, String> CACHE = new HashMap<>();

    public SQLQueriesServiceProxy(SQLQueryService sqlQueryService){
        this.sqlQueryService = sqlQueryService;
    }
    @Override
    public String constructSQLSearchUserByID(String id) {
        // DO some additional staff
        System.out.println("User id called = " + id);
        String sql = CACHE.get(id);
        if(sql == null){
            String realSQL = sqlQueryService.constructSQLSearchUserByID(id);
            CACHE.put(id, realSQL);
            return realSQL;
        }
        return sql;
    }
}
