package com.kurs.server.database;

import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeVisibilityForDish {
    private static final Logger serverLogger = Logger.getLogger("server");

    public ChangeVisibilityForDish(Request r) {
        String request = "UPDATE " + new Prop().getMenuTableName() + " SET visible=true WHERE id=" + r.getDishID();
        try {
            PreparedStatement statement = new DBConnection().getConnection().prepareStatement(request);
            statement.executeUpdate();
            serverLogger.info("Была одобрена заявка на добавление в меню для блюда с id = " + r.getDishID());
        } catch (SQLException e) {
            serverLogger.error("Была попытка одобрить заявку на добавление блюда с id = " + r.getDishID() + " в меню, но - " + e.getMessage());
        }

    }
}
