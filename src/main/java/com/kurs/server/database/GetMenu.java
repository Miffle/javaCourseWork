package com.kurs.server.database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMenu {
    private static final Logger serverLogger = Logger.getLogger("server");

    public GetMenu() {
        Connection connection = new DBConnection().getConnection();
        String request = "SELECT * FROM " + new Prop().getMenuTableName() + " WHERE visible=1";
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();
            InputInStorage.setAllDishes(resultSet);
            connection.close();
            serverLogger.info("Покупатель получил копию меню");
        } catch (SQLException e) {
            serverLogger.error("Кто-то помешал покупателю посмотреть меню :( - " + e.getMessage());
        }

    }

}
