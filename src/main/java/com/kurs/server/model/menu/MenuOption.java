package com.kurs.server.model.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuOption {
    private int id;
    private String name;
    private double price;
    private boolean visible;

    public MenuOption(int id, String name, double price, boolean visible) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.visible = visible;
    }
}
