package com.kurs.server.database;

import com.kurs.server.model.menu.MenuArray;
import com.kurs.server.model.menu.MenuOption;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InputInStorage {
    public static void setAllDishes(ResultSet resultSet) throws SQLException {
        MenuArray.menu.clear();
        while (resultSet.next()) {
            MenuArray.menu.add(
                    new MenuOption(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getBoolean(4)
                    ));
        }
    }

}
