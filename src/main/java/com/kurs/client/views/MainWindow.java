package com.kurs.client.views;

import com.kurs.client.Roles;
import com.kurs.client.controllers.mainwindow.chef.ChefWindowController;
import com.kurs.client.controllers.mainwindow.guest.GuestWindowController;
import com.kurs.client.controllers.mainwindow.staff.StaffWindowController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow {

    public MainWindow(Stage stage, Roles role) {
        stage.setTitle("ухмргмще");
        stage.setScene(setScene(role));
        stage.setWidth(350);
        stage.setHeight(500);
        stage.show();
    }

    private Scene setScene(Roles role) {
        switch (role) {
            case GUEST -> {
                return new GuestWindowController().createGuestScene();
            }
            case CHEF -> {
                return new ChefWindowController().createChefScene();
            }
            case OGUZOK -> {
                return new StaffWindowController().createStaffScene();
            }
            default -> {
                return null;
            }
        }
    }
}
