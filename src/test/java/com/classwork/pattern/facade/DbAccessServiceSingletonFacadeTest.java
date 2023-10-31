package com.classwork.pattern.facade;

import com.classwork.pattern.facade.service.DbAccessService;
import com.classwork.pattern.facade.service.DbAccessServiceFacade;
import com.classwork.pattern.proxy.service.sql.DbConnectionMySqlService;
import com.classwork.pattern.proxy.service.sql.DbConnectionService;
import com.classwork.pattern.proxy.service.sql.SqlQueriesService;
import com.classwork.pattern.proxy.service.sql.SqlQueriesServiceGeneric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DbAccessServiceSingletonFacadeTest {

    String EXP = "getting SELECT * FROM user WHERE id = getting SELECT * FROM user WHERE id = 1";
    String id = "1";

    private SqlQueriesService sqlQueriesService;

    private DbConnectionService dbConnectionService;

    @BeforeEach
    void setUp() {
        this.sqlQueriesService = new SqlQueriesServiceGeneric();
        this.dbConnectionService = new DbConnectionMySqlService();
    }

    @Test
    void testPath() {
        DbAccessService db = new DbAccessServiceFacade(sqlQueriesService, dbConnectionService);
        String userById = db.getUserById(db.getUserById(id));
        assertEquals(EXP, userById);
    }

    @Test
    void testMock() {
        DbConnectionService mocked = mock(DbConnectionService.class);
        DbAccessService dbAccessService = new DbAccessServiceFacade(sqlQueriesService, mocked);
        Mockito.when(mocked.invoke(anyString())).thenReturn(EXP);
        String userById = dbAccessService.getUserById(id);
        assertEquals(EXP, userById);
        verify(mocked, times(1)).invoke("SELECT * FROM user WHERE id = 1");
    }
}