package com.kurs.client.controllers.startwindow.oguzok;

import com.kurs.client.Roles;
import com.kurs.client.controllers.startwindow.MakeMenuTable;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.views.MainWindow;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.log4j.Logger;

public class OguzokController {
    private static final Logger staffLogger = Logger.getLogger("oguzok");

    public OguzokController(Button button, Roles roles) {
        button.setOnAction(actionEvent -> {
            Window window = button.getParent().getScene().getWindow();
            MakeMenuTable.makeMenuTable(SendRequest.sendRequest(2));
            new MainWindow(new Stage(), roles);
            window.hide();
            staffLogger.info("Открыто окно для огузка и закрыто стартовое");
        });
    }

}
