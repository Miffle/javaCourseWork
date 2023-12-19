package com.kurs.client.controllers.mainwindow.guest;

import com.kurs.client.controllers.mainwindow.GetSelectedDishId;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.menu.AllMenuOptionsArray;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.client.elements.menu.OrderArray;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;

public class AddToOrderButtonHandler {
    private static final Logger guestLogger = Logger.getLogger("guest");
    private final TableView<MenuOption> orderTable;
    private int selectedDishID;

    public AddToOrderButtonHandler(TableView<MenuOption> table, TableView<MenuOption> orderTable, Boxes boxes) {
        this.orderTable = orderTable;
        boxes.getButtons().getAddToOrder().setOnAction(actionEvent -> {
            selectedDishID = GetSelectedDishId.getId(table);
            copyDishToOrderList();
            orderTable.refresh();
        });
    }

    private void copyDishToOrderList() {
        OrderArray.order.add(AllMenuOptionsArray.menu.stream().filter(menuOption -> selectedDishID == menuOption.getId()).findFirst().orElse(null));
        orderTable.refresh();
        guestLogger.info("Блюдо с id = " + selectedDishID + " было добавлено в заказ");
    }

}
