package vladproduction.com.app01.service;

public class DbConnectionServiceImpl implements DbConnectionService {
    @Override
    public String invokeSql(String sql) {

        System.out.println("Setup connection, get connection from pool, invoke sql");

        return "result of getting user by id sql = " + sql;
    }
}
