package com.kurs.protocols.server;

import com.kurs.server.model.menu.MenuOption;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Response {
    private final int responseStatus;
    private List<MenuOption> menu = null;

    public Response(List<MenuOption> menu) {
        this.responseStatus = 200;
        this.menu = menu;
    }

    public Response(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}
