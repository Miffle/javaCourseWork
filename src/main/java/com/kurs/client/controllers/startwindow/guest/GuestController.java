package com.kurs.client.controllers.startwindow.guest;

import com.kurs.client.Roles;
import com.kurs.client.controllers.startwindow.MakeMenuTable;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.views.MainWindow;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.log4j.Logger;

public class GuestController {
    private static final Logger guestLogger = Logger.getLogger("guest");

    public GuestController(Button button, Roles roles) {
        button.setOnAction(actionEvent -> {
            Window window = button.getParent().getScene().getWindow();
            MakeMenuTable.makeMenuTable(SendRequest.sendRequest(1));
            new MainWindow(new Stage(), roles);
            window.hide();
            guestLogger.info("Открыто окно для пользователя и закрыто стартовое");

        });
    }


}
