package com.kurs.client.elements.menu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MenuOption {
    private int id;
    private String name;
    private double price;
    private boolean visible;
}
