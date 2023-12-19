package com.kurs.client.controllers.startwindow.chef;

import com.kurs.client.Roles;
import com.kurs.client.controllers.startwindow.MakeMenuTable;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.views.MainWindow;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.log4j.Logger;

public class ChefController {
    private static final Logger chefLogger = Logger.getLogger("chef");

    public ChefController(Button button, Roles roles) {
        button.setOnAction(actionEvent -> {
            Window window = button.getParent().getScene().getWindow();
            MakeMenuTable.makeMenuTable(SendRequest.sendRequest(2));
            new MainWindow(new Stage(), roles);
            window.hide();
            chefLogger.info("Открыто окно для шефа и закрыто стартовое");
        });
    }

}
