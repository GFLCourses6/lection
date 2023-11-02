package vladproduction.com.app02;

import java.util.HashMap;
import java.util.Map;

public class SQLQueriesServiceProxy implements SQLService {

    private final SQLService sqlService;

    private final Map<String, String> cache = new HashMap<>();

    public SQLQueriesServiceProxy(SQLService sqlService) {
        this.sqlService = sqlService;
    }

    @Override
    public String searchUserById(String id) {
        //here additional functional
        System.out.println("User id called = " + id);
        //here real method
        String sql = cache.get(id);
        if(sql == null){
            String realSql = sqlService.searchUserById(id);
            cache.put(id, realSql);
            return realSql;
        }
        return sql;
    }
}
