package com.kurs.client.controllers.startwindow;

import com.google.gson.Gson;
import com.kurs.client.elements.menu.AllMenuOptionsArray;
import com.kurs.protocols.client.Response;

public class MakeMenuTable {
    public static void makeMenuTable(String r) {
        Response response = new Gson().fromJson(r, Response.class);
        AllMenuOptionsArray.menu.clear();
        AllMenuOptionsArray.menu.addAll(response.getMenu());
    }

}
