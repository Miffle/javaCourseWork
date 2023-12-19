package com.kurs.client.controllers.mainwindow.staff;

import com.kurs.client.Roles;
import com.kurs.client.controllers.AutoTableUpdate;
import com.kurs.client.elements.Boxes;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.client.elements.menu.MenuTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class StaffWindowController {
    private final Boxes boxes = new Boxes();
    private final TableView<MenuOption> table = new MenuTable(Roles.OGUZOK).getMenu();
    private VBox firstVBox;
    private VBox secondVBox;

    public Scene createStaffScene() {
        new OfferNewDishButtonHandler(boxes);
        createFirstVBox();
        createSecondVBox();
        VBox mainVBox = new VBox(firstVBox, secondVBox);
        return new Scene(mainVBox);
    }

    private void createFirstVBox() {
        firstVBox = new VBox(table);
        new Thread(new AutoTableUpdate(table, 2)).start();
        firstVBox.setAlignment(Pos.TOP_CENTER);
    }

    private void createSecondVBox() {
        secondVBox = new VBox(boxes.getOfferNewDishVBox());
        secondVBox.setAlignment(Pos.CENTER);
    }
}
