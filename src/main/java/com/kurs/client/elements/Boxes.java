package com.kurs.client.elements;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Getter;

@Getter
public class Boxes {
    private final Labels labels = new Labels();
    private final Buttons buttons = new Buttons();
    private final TextFields fields = new TextFields();
    private final VBox authorizationVBox = new VBox();

    public VBox getAuthorizationVBox() {
        HBox hBox = new HBox(buttons.getAsChef(), buttons.getAsOguzok());
        hBox.setAlignment(Pos.CENTER);
        authorizationVBox.getChildren().add(labels.getLoginLabel());
        authorizationVBox.getChildren().add(hBox);
        authorizationVBox.getChildren().add(buttons.getAsGuest());
        return authorizationVBox;
    }

    public VBox getOfferNewDishVBox() {
        return new VBox(
                labels.getOfferNewDish(),
                fields.getOfferDishNameInput(),
                labels.getPrice(),
                fields.getOfferDishPriceInput(),
                buttons.getOfferNewDish());
    }

    public VBox getAddNewDishVBox() {
        return new VBox(
                labels.getAddNewDish(),
                fields.getAddNewDishNameInput(),
                labels.getPrice(),
                fields.getAddNewDishPriceInput(),
                buttons.getAddNewDish());
    }

    public VBox getBrokeVBox() {
        return new VBox(
                labels.getBroke(),
                buttons.getBroke());
    }

}
