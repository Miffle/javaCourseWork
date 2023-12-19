package com.kurs.client.controllers.mainwindow.chef;

import com.google.gson.Gson;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.Boxes;
import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

public class AddNewDishButtonHandler {
    private static final Logger chefLogger = Logger.getLogger("chef");

    public AddNewDishButtonHandler(Boxes boxes) {
        boxes.getButtons().getAddNewDish().setOnAction(actionEvent -> {
            String newDishName = boxes.getFields().getAddNewDishNameInput().getText();
            Double newDishPrice = Double.valueOf(boxes.getFields().getAddNewDishPriceInput().getText());
            String request = new Gson().toJson(new Request(5, newDishName, newDishPrice));
            SendRequest.sendRequest(request);
            chefLogger.info("Отправлен запрос на добавления нового блюда - " + newDishName + " ценой " + newDishPrice + " в меню");
        });
    }
}
