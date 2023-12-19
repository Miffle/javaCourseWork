package com.kurs.client.controllers.mainwindow.staff;

import com.google.gson.Gson;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.Boxes;
import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

public class OfferNewDishButtonHandler {
    private static final Logger staffLogger = Logger.getLogger("oguzok");

    public OfferNewDishButtonHandler(Boxes boxes) {
        boxes.getButtons().getOfferNewDish().setOnAction(actionEvent -> {
            String offeredDishName = boxes.getFields().getOfferDishNameInput().getText();
            Double offeredDishPrice = Double.valueOf(boxes.getFields().getOfferDishPriceInput().getText());
            SendRequest.sendRequest(new Gson().toJson(new Request(4, offeredDishName, offeredDishPrice)));
            staffLogger.info("Отправлен запрос на добавление нового блюда в меню (для рассмотрения)");
        });
    }
}
