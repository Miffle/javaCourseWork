package com.kurs.client.elements;

import javafx.scene.control.Button;
import lombok.Getter;

@Getter
public class Buttons {
    private final Button asGuest = new Button("Как гость");
    private final Button asOguzok = new Button("Как огузок");
    private final Button asChef = new Button("Как шеф");

    private final Button addToOrder = new Button("Добавить в заказ");
    private final Button makeOrder = new Button("Заказать");

    private final Button OfferNewDish = new Button("Подтвердить");
    private final Button addNewDish = new Button("Подтвердить");
    private final Button acceptOffer = new Button("Принять блюдо");
    private final Button deleteDish = new Button("Удалить блюдо");
    private final Button broke = new Button("Подтвердить");
}
