package com.kurs.client.elements;

import javafx.scene.control.Label;
import lombok.Getter;

@Getter
public class Labels {
    private final Label menu = new Label("Меню");
    private final Label loginLabel = new Label("Как будем использовать приложение?");
    private final Label makeOrder = new Label("Заказать блюдо");
    private final Label OfferNewDish = new Label("Предложить блюдо");

    private final Label addNewDish = new Label("Добавить новое блюдо");
    private final Label price = new Label("Цена");

    private final Label acceptOffer = new Label("Принять заявку на добавление");
    private final Label deleteDish = new Label("Удалить блюдо");
    private final Label broke = new Label("Разориться");
}
