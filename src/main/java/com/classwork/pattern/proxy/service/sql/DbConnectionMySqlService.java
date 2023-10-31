package com.classwork.pattern.proxy.service.sql;

public class DbConnectionMySqlService implements DbConnectionService{
    @Override
    public String invoke(String sql) {
        System.out.println("setup DbConnection");
        return "getting " + sql;
    }
}
