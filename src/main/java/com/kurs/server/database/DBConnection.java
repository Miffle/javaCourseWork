package com.kurs.server.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private final Connection connection;
    private final Prop prop = new Prop();

    public DBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+prop.getDBName(), prop.getDBLogin(), prop.getDBPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
