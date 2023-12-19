package com.kurs.client;

import com.kurs.client.views.StartWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        new StartWindow(primaryStage);
    }
}
