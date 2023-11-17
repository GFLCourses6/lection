package com.ua.proxy.sql;

import com.ua.sql.SqlQueriesService;
import com.ua.sql.SqlQueriesServiceGeneric;
import com.ua.sql.SqlQueriesServiceProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqlQueriesServiceTest {

    SqlQueriesService service;

    @BeforeEach
    void setup() {
        service = new SqlQueriesServiceGeneric();
    }

    @Test
    void testProxy() {
        assertEquals("SELECT * FROM user WHERE id = 1",
                     service.constructSqlSearchUserById("1"));
        service = new SqlQueriesServiceProxy(service);
        assertEquals("SELECT * FROM user WHERE id = 1",
                     service.constructSqlSearchUserById("1"));
    }

    @Test
    void testProxyFlag() {

    }

}