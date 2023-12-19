package com.kurs.client.controllers.mainwindow.chef;

import com.google.gson.Gson;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.Boxes;
import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

public class BrokeButtonHandler {
    private static final Logger chefLogger = Logger.getLogger("chef");

    public BrokeButtonHandler(Boxes boxes) {
        boxes.getButtons().getBroke().setOnAction(
                actionEvent -> {
                    SendRequest.sendRequest(new Gson().toJson(new Request(8)));
                    chefLogger.info("Отправлен запрос на банкротство :(");
                });
    }
}
