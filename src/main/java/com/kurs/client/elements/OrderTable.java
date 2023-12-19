package com.kurs.client.elements;

import com.kurs.client.elements.menu.MenuOption;
import com.kurs.client.elements.menu.OrderArray;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;

@Getter
public class OrderTable {
    public final TableColumn<MenuOption, Integer> idColumn = new TableColumn<>("id");
    public final TableColumn<MenuOption, String> nameColumn = new TableColumn<>("Название блюда");
    public final TableColumn<MenuOption, Double> priceColumn = new TableColumn<>("Цена");
    private final TableView<MenuOption> order = new TableView<>(FXCollections.observableList(OrderArray.order));

    public OrderTable() {
        createColumns();
    }

    private void createColumns() {
        setCamerasFactory();
        addCameraColumns();
        order.setPrefHeight(200);
    }

    public void updateTable() {
        order.setItems(FXCollections.observableList(OrderArray.order));
    }

    private void addCameraColumns() {
        order.getColumns().add(idColumn);
        order.getColumns().add(nameColumn);
        order.getColumns().add(priceColumn);
    }

    private void setCamerasFactory() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
