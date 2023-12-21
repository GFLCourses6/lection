package com.ua.db.service;

public class Query {

    private Query() {
    }

    public static final String UPDATE = "update birds set description=? WHERE bird=?";
    public static final String DELETE = "delete from birds where bird=?";
    public static final String INSERT = "insert into birds(bird, description) values (?, ?)";
    public static final String SELECT_ALL = "SELECT * FROM birds";
    public static final String SELECT_BY = "select * from birds where bird=?";
}
