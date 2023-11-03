package com.classwork.pattern.facade;

import com.classwork.pattern.facade.service.DbAccessService;
import com.classwork.pattern.facade.service.DbAccessServiceFacade;
import com.classwork.pattern.proxy.service.sql.DbConnectionPostgreSqlService;
import com.classwork.pattern.proxy.service.sql.DbConnectionService;
import com.classwork.pattern.proxy.service.sql.SqlQueriesService;
import com.classwork.pattern.proxy.service.sql.SqlQueriesServiceGeneric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DbAccessServiceSingletonFacadeTest {

    String EXP = "getting SELECT * FROM user WHERE id = getting SELECT * FROM user WHERE id = 1";
    String id = "1";

    private SqlQueriesService sqlQueriesService;

    private DbConnectionService dbConnectionService;

    @BeforeEach
    void setUp() {
        this.sqlQueriesService = new SqlQueriesServiceGeneric();
        this.dbConnectionService = new DbConnectionPostgreSqlService();
    }

@Test
    void testMock() {
        dbConnectionService = mock(DbConnectionService.class);
        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlQueriesService, dbConnectionService);
        when(dbConnectionService.invoke(anyString())).thenReturn(EXP);
        String userById = dbAccessService.getUserById(id);
        assertEquals(EXP, userById);
        verify(dbConnectionService, times(1)).invoke("SELECT * FROM user WHERE id = 1");
    }
}
