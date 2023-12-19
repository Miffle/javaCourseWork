package com.kurs.server.database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GetMenuByStaff {
    private static final Logger serverLogger = Logger.getLogger("server");

    public GetMenuByStaff() {
        Connection connection = new DBConnection().getConnection();
        String request = "SELECT * FROM " + new Prop().getMenuTableName();
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet resultSet = statement.executeQuery();
            InputInStorage.setAllDishes(resultSet);
            connection.close();
            serverLogger.info("Сотрудник получил копию меню");
        } catch (SQLException e) {
            serverLogger.error("Кто-то помешал сотруднику посмотреть меню :( - " + e.getMessage());
        }
    }
}
