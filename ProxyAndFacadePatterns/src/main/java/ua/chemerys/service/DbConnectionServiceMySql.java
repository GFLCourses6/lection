package ua.chemerys.service;

public class DbConnectionServiceMySql implements DbConnectionService{
    @Override
    public String invokeSql(String sql) {

        System.out.println("Just imagine that here is setup connection, get connection from pool, invoke SQL");
        return "Result of getting user by id SQL = " + sql;
    }
}
