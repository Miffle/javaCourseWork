package com.kurs.server.database;

import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewDishInDB {
    private static final Logger serverLogger = Logger.getLogger("server");

    public AddNewDishInDB(Request r, boolean visible) {
        String request = "INSERT INTO main_menu(dish_name, price, visible) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = new DBConnection().getConnection().prepareStatement(request);
            preparedStatement.setString(1, r.getNewDishName());
            preparedStatement.setDouble(2, r.getNewDishPrice());
            preparedStatement.setBoolean(3, visible);
            preparedStatement.executeUpdate();
            serverLogger.info("Добавлено новое блюдо - " + r.getNewDishName() + " за " + r.getNewDishPrice());
        } catch (SQLException e) {
            serverLogger.error("Не удалось добавить блюдо в базу данных! Ошибка - " + e.getMessage());
        }

    }
}
