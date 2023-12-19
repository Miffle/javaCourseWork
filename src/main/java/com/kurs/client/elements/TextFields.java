package com.kurs.client.elements;

import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class TextFields {
    //oguzok
    private final TextField offerDishNameInput = new TextField("Название");
    private final TextField offerDishPriceInput = new TextField("1");
    //chef
    private final TextField addNewDishNameInput = new TextField("Название");
    private final TextField addNewDishPriceInput = new TextField("1");

    public TextFields() {
        makeOnlyNum(offerDishPriceInput);
        makeOnlyNum(addNewDishPriceInput);
        makeNotEmptyNum(offerDishPriceInput);
        makeNotEmptyNum(addNewDishPriceInput);
        makeNotEmptyString(offerDishNameInput);
        makeNotEmptyString(addNewDishNameInput);
    }

    private void makeOnlyNum(TextField tf) {
        tf.textProperty().addListener((observableValue, s, t1) -> {
            if (!t1.matches("\\d*")) {
                tf.setText(t1.replaceAll("\\D", ""));
            }
        });
    }

    private void makeNotEmptyString(TextField tf) {
        tf.textProperty().addListener((observableValue, s, t1) -> {
            if (tf.getText().isEmpty()) {
                tf.setText("Попа");
            }
        });
    }

    private void makeNotEmptyNum(TextField tf) {
        tf.textProperty().addListener((observableValue, s, t1) -> {
            if (tf.getText().isEmpty()) {
                tf.setText("1");
            }
        });
    }
}

