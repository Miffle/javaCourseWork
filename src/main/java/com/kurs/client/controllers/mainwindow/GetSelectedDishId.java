package com.kurs.client.controllers.mainwindow;

import com.kurs.client.elements.menu.MenuOption;
import javafx.scene.control.TableView;

public class GetSelectedDishId {
    public static int getId(TableView<MenuOption> table) {
        return (int) table.getColumns().getFirst().getCellObservableValue(table.getSelectionModel().getFocusedIndex()).getValue();
    }
}
