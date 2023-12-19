package com.kurs.client.controllers.mainwindow.guest;

import com.google.gson.Gson;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.menu.OrderArray;
import com.kurs.protocols.Request;
import org.apache.log4j.Logger;

public class MakeOrderButtonHandler {
    private static final Logger guestLogger = Logger.getLogger("guest");

    public MakeOrderButtonHandler(Boxes boxes) {
        boxes.getButtons().getMakeOrder().setOnAction(actionEvent -> {
            SendRequest.sendRequest(new Gson().toJson(new Request(3, OrderArray.order)));
            guestLogger.info("Пользователем оформил заказ");
        });
    }
}
