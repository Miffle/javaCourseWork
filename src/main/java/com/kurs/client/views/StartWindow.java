package com.kurs.client.views;

import com.kurs.client.controllers.startwindow.StartWindowController;
import com.kurs.client.elements.Boxes;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartWindow {
    private final Boxes boxes = new Boxes();

    public StartWindow(Stage stage) {
        stage.setScene(makeScene());
        stage.setWidth(350);
        stage.setHeight(500);
        stage.setTitle("Джава");
        stage.show();

    }

    private Scene makeScene() {
        VBox vBox = boxes.getAuthorizationVBox();
        vBox.setAlignment(Pos.CENTER);
        new StartWindowController(boxes);
        return new Scene(vBox);
    }
}
