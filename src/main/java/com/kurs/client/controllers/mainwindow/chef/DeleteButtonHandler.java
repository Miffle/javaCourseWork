package com.kurs.client.controllers.mainwindow.chef;

import com.google.gson.Gson;
import com.kurs.client.controllers.mainwindow.GetSelectedDishId;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.protocols.Request;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;

public class DeleteButtonHandler {
    private static final Logger chefLogger = Logger.getLogger("chef");
    private Integer selectedDishID;

    public DeleteButtonHandler(TableView<MenuOption> table, Boxes boxes) {
        boxes.getButtons().getDeleteDish().setOnAction(actionEvent -> {
            selectedDishID = GetSelectedDishId.getId(table);
            deleteFromDataBase();
        });

    }

    private void deleteFromDataBase() {
        SendRequest.sendRequest(new Gson().toJson(new Request(6, selectedDishID)));
        chefLogger.info("Отправлен запрос на удаление блюда с ID = " + selectedDishID + "из меню");
    }

}
