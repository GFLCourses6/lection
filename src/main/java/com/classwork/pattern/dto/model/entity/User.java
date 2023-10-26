package com.classwork.pattern.dto.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User
        implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private Long timestamp;
    private List<Ship> ships;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.ships = new ArrayList<Ship>();
        this.timestamp = Timestamp.valueOf(LocalDateTime.now()).getTime();
    }

    public User() {

    }

    public void addShip(Ship ship) {
        if (this.ships == null) {
            this.ships = new ArrayList<Ship>();
        }
        this.ships.add(ship);
    }

    public List<Ship> getShips() {
        return this.ships;
    }

    public Integer getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String toString() {
        return String.format(
                "{name: %s, surname: %s, ship: %s}",
                getName(), getSurname(), getShips());
    }
}
