package com.kurs.client.elements.menu;

import com.kurs.client.Roles;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;

@Getter
public class MenuTable {
    public final TableColumn<MenuOption, Integer> idColumn = new TableColumn<>("id");
    public final TableColumn<MenuOption, String> nameColumn = new TableColumn<>("Название блюда");
    public final TableColumn<MenuOption, Double> priceColumn = new TableColumn<>("Цена");
    public final TableColumn<MenuOption, Double> visibleColumn = new TableColumn<>("Одобрено");
    private final TableView<MenuOption> menu = new TableView<>(FXCollections.observableList(AllMenuOptionsArray.menu));
    private final Roles role;

    public MenuTable(Roles role) {
        this.role = role;
        createColumns();
    }

    private void createColumns() {
        setCamerasFactory();
        addCameraColumns();
        menu.setPrefHeight(200);
    }

    private void addCameraColumns() {
        menu.getColumns().add(idColumn);
        menu.getColumns().add(nameColumn);
        menu.getColumns().add(priceColumn);
        if (this.role != Roles.GUEST) {
            menu.getColumns().add(visibleColumn);
        }
    }

    private void setCamerasFactory() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        if (role != Roles.GUEST) {
            visibleColumn.setCellValueFactory(new PropertyValueFactory<>("visible"));
        }
    }
}
