package com.kurs.server.database;

import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClearDB {
    private static final Logger serverLogger = Logger.getLogger("server");

    public ClearDB() {
        String request = "DELETE FROM main_menu";
        try {
            PreparedStatement statement = new DBConnection().getConnection().prepareStatement(request);
            statement.executeUpdate();
            serverLogger.info("Мы разорились :(");
        } catch (SQLException e) {
            serverLogger.error("Мы чуть было не разорились, но ошибка " + e.getMessage() + " спасла нас");
        }
    }
}
