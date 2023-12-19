package com.kurs.client.controllers.mainwindow.guest;

import com.kurs.client.Roles;
import com.kurs.client.controllers.AutoTableUpdate;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.Labels;
import com.kurs.client.elements.OrderTable;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.client.elements.menu.MenuTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;


public class GuestWindowController {
    private final Boxes boxes = new Boxes();
    private final Labels labels = boxes.getLabels();

    private final VBox firstVBox = new VBox();
    private final VBox secondVBox = new VBox();
    private final VBox thirdVBox = new VBox();
    private final TableView<MenuOption> table = new MenuTable(Roles.GUEST).getMenu();
    private final TableView<MenuOption> orderTable = new OrderTable().getOrder();

    public Scene createGuestScene() {
        makeVBoxes();
        new AddToOrderButtonHandler(table, orderTable, boxes);
        new MakeOrderButtonHandler(boxes);
        VBox mainVBox = new VBox(firstVBox, secondVBox, thirdVBox);
        return new Scene(mainVBox);
    }

    private void makeVBoxes() {
        makeFirstVBox();
        makeSecondVBox();
        makeThirdVBox();
    }

    private void makeFirstVBox() {
        firstVBox.getChildren().add(labels.getMenu());
        firstVBox.setAlignment(Pos.TOP_CENTER);
    }

    private void makeSecondVBox() {
        secondVBox.getChildren().add(table);
        new Thread(new AutoTableUpdate(table, 1)).start();
        secondVBox.getChildren().add(orderTable);
    }

    private void makeThirdVBox() {
        thirdVBox.getChildren().add(boxes.getButtons().getAddToOrder());
        thirdVBox.getChildren().add(boxes.getButtons().getMakeOrder());
        thirdVBox.setAlignment(Pos.BOTTOM_CENTER);
    }


}
