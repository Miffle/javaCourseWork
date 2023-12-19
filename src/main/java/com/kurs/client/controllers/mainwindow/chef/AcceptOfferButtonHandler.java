package com.kurs.client.controllers.mainwindow.chef;

import com.google.gson.Gson;
import com.kurs.client.controllers.mainwindow.GetSelectedDishId;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.protocols.Request;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;

public class AcceptOfferButtonHandler {
    private static final Logger chefLogger = Logger.getLogger("chef");
    private Integer selectedDishID;

    public AcceptOfferButtonHandler(TableView<MenuOption> table, Boxes boxes) {
        boxes.getButtons().getAcceptOffer().setOnAction(actionEvent -> {
            selectedDishID = GetSelectedDishId.getId(table);
            acceptOffer();
        });

    }

    private void acceptOffer() {
        SendRequest.sendRequest(new Gson().toJson(new Request(7, selectedDishID)));
        chefLogger.info("Отправлен запрос для одобрения заявки огузка на добавление блюда с id = " + selectedDishID + " в меню");

    }

}
