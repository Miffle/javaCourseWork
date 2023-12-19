package com.kurs.client.controllers;

import com.google.gson.Gson;
import com.kurs.client.controllers.startwindow.MakeMenuTable;
import com.kurs.client.controllers.startwindow.SendRequest;
import com.kurs.client.elements.menu.MenuOption;
import com.kurs.protocols.Request;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;


public class AutoTableUpdate implements Runnable {
    private static final Logger guestLogger = Logger.getLogger("guest");
    private static final Logger staffLogger = Logger.getLogger("oguzok");
    private static final Logger chefLogger = Logger.getLogger("chef");
    private final TableView<MenuOption> table;
    private final int requestID;

    public AutoTableUpdate(TableView<MenuOption> table, int requestID) {
        this.table = table;
        this.requestID = requestID;
    }

    public void autoUpdateTable() {
        while (true) {
            try {
                Thread.sleep(5000);
                MakeMenuTable.makeMenuTable(SendRequest.sendRequest(new Gson().toJson(new Request(requestID))));
                table.refresh();
                if (requestID == 2) {
                    staffLogger.info("Таблица с меню была автоматически обновлена");
                    chefLogger.info("Таблица с меню была автоматически обновлена");
                } else {
                    guestLogger.info("Таблица с меню была автоматически обновлена");
                }
                if (!table.getParent().getScene().getWindow().isShowing()) break;
            } catch (InterruptedException e) {
                if (requestID == 2) {
                    staffLogger.info("Возникла ошибка при обновлении таблицы " + e.getMessage());
                    chefLogger.info("Возникла ошибка при обновлении таблицы " + e.getMessage());
                } else {
                    guestLogger.info("Возникла ошибка при обновлении таблицы " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void run() {
        autoUpdateTable();
    }
}
