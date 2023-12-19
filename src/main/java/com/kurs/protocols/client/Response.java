package com.kurs.protocols.client;

import com.kurs.client.elements.menu.MenuOption;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Response {
    private final int responseStatus;
    private final List<MenuOption> menu;

    public Response(ArrayList<MenuOption> menu) {
        this.responseStatus = 200;
        this.menu = menu;
    }

}
