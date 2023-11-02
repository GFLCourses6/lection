package vladproduction.com.app02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProxyTest {

    @Test
    public void positive(){
        SQLService sqlService = new SQLQueriesService();
        assertEquals("SELECT * FROM user where id = 111", sqlService.searchUserById("111"));

        sqlService = new SQLQueriesServiceProxy(sqlService);
        assertEquals("SELECT * FROM user where id = 111", sqlService.searchUserById("111"));
    }


}
