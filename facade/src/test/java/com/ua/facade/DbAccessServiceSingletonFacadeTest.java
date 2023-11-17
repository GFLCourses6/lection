package com.ua.facade;

import com.ua.facade.service.DbAccessService;
import com.ua.facade.service.DbAccessServiceFacade;
import com.ua.facade.service.DbConnectionPostgreSqlService;
import com.ua.facade.service.DbConnectionService;
import com.ua.sql.SqlQueriesService;
import com.ua.sql.SqlQueriesServiceGeneric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DbAccessServiceSingletonFacadeTest {

    String EXP =
            "getting SELECT * FROM user WHERE id = getting SELECT * FROM user WHERE id = 1";
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
        DbAccessService dbAccessService =
                new DbAccessServiceFacade(sqlQueriesService,
                        dbConnectionService);
        when(dbConnectionService.invoke(anyString())).thenReturn(EXP);
        String userById = dbAccessService.getUserById(id);
        assertEquals(EXP, userById);
        verify(dbConnectionService, times(1)).invoke(
                "SELECT * FROM user WHERE id = 1");
    }
}
