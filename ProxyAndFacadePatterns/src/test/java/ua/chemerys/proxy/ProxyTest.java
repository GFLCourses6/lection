package ua.chemerys.proxy;

import org.junit.Test;
import ua.chemerys.service.SQLQueriesService;
import ua.chemerys.service.SQLQueryServiceGeneric;

import static junit.framework.Assert.assertEquals;

public class ProxyTest {

    @Test
    public void happyPath() {
        SQLQueriesService sqlQueriesService = new SQLQueryServiceGeneric();
        assertEquals("SELECT * FROM user where id = randomId", sqlQueriesService.constructSqlSearchUserById("randomId"));

        sqlQueriesService = new SQLQueriesServiceProxy(sqlQueriesService);
        assertEquals("SELECT * FROM user where id = randomId", sqlQueriesService.constructSqlSearchUserById("randomId"));
    }
}
