package com.kurs.client.controllers.mainwindow.chef;

import com.kurs.client.Roles;
import com.kurs.client.controllers.AutoTableUpdate;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.client.elements.menu.MenuTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ChefWindowController {
    private final Boxes boxes = new Boxes();
    private final VBox firstVBox = new VBox();
    private final VBox secondVBox = new VBox();
    private final VBox thirdVBox = new VBox();
    private final TableView<MenuOption> table = new MenuTable(Roles.CHEF).getMenu();

    public Scene createChefScene() {
        createEventListeners();
        makePrettyVBox();
        VBox mainVBox = new VBox(firstVBox, secondVBox, thirdVBox);
        new Thread(new AutoTableUpdate(table, 2)).start();
        return new Scene(mainVBox);
    }

    private void createEventListeners() {
        new AddNewDishButtonHandler(boxes);
        new DeleteButtonHandler(table, boxes);
        new AcceptOfferButtonHandler(table, boxes);
        new BrokeButtonHandler(boxes);
    }

    private void makePrettyVBox() {
        createSecondVBox();
        createFirstVBox();
        firstVBox.setAlignment(Pos.TOP_CENTER);
        secondVBox.setAlignment(Pos.CENTER);
        thirdVBox.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void createFirstVBox() {
        firstVBox.getChildren().add(table);
        firstVBox.getChildren().add(boxes.getButtons().getDeleteDish());
        firstVBox.getChildren().add(boxes.getButtons().getAcceptOffer());
    }

    private void createSecondVBox() {
        secondVBox.getChildren().add(boxes.getAddNewDishVBox());
        secondVBox.getChildren().add(boxes.getBrokeVBox());
    }

}
