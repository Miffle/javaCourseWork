package com.kurs.server.database;

import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRowFromDB {

    private static final Logger serverLogger = Logger.getLogger("server");

    public DeleteRowFromDB(Request r) {
        String request = "DELETE FROM " + new Prop().getMenuTableName() + " WHERE id=" + r.getDishID();
        try {
            PreparedStatement statement = new DBConnection().getConnection().prepareStatement(request);
            statement.executeUpdate();
            serverLogger.info("Блюдо с ID = " + r.getDishID() + " было удалено из меню");
        } catch (SQLException e) {
            serverLogger.error("Блюдо с ID = " + r.getDishID() + " хотели удалить из меню, но им помешало - " + e.getMessage());
        }

    }
}
