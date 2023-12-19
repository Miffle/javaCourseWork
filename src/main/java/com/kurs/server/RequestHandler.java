package com.kurs.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kurs.protocols.Request;
import com.kurs.protocols.server.Response;
import com.kurs.server.database.*;
import com.kurs.server.model.menu.MenuArray;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private static final Logger serverLogger = Logger.getLogger("server");
    private final Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    private void startProcessing() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = in.readLine();
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            Request request = gson.fromJson(line, Request.class);
            switch (request.getRequestID()) {
                case 1 -> {
                    serverLogger.info("Пришёл запрос на получение меню для пользователя");
                    new GetMenu();
                    sendResponse(new Gson().toJson(new Response(MenuArray.menu)));
                }
                case 2 -> {
                    serverLogger.info("Пришёл запрос на получение меню для сотрудника");
                    new GetMenuByStaff();
                    sendResponse(new Gson().toJson(new Response(MenuArray.menu)));
                }
                case 3 -> {
                    serverLogger.info("Пришёл заказ от пользователя");
                    sendResponse(new Gson().toJson(new Response(200)));
                }
                case 4 -> {
                    serverLogger.info("Пришёл запрос на добавление нового блюда в меню(надо подтвердить)");
                    new AddNewDishInDB(request, false);
                    sendResponse(new Gson().toJson(new Response(200)));
                }
                case 5 -> {
                    serverLogger.info("Пришёл запрос на добавление нового блюда в меню(подтверждать не надо)");
                    new AddNewDishInDB(request, true);
                    sendResponse(new Gson().toJson(new Response(200)));
                }
                case 6 -> {
                    serverLogger.info("Пришёл запрос на удаление блюда из базы данных");
                    new DeleteRowFromDB(request);
                    sendResponse(new Gson().toJson(new Response(200)));
                }
                case 7 -> {
                    serverLogger.info("Пришёл запрос на подтверждение блюда(мои поздравления огузку)");
                    new ChangeVisibilityForDish(request);
                    sendResponse(new Gson().toJson(new Response(200)));
                }
                case 8 -> {
                    serverLogger.info("Пришёл запрос на разориться :(");
                    new ClearDB();
                    sendResponse(new Gson().toJson(new Response(200)));
                }
            }
        } catch (IOException e) {
            serverLogger.error("Пришёл какой-то странный запрос, я ничего не понял - " + e.getMessage());
        }
    }

    private void sendResponse(String t) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(t + "\n");
            out.flush();
            serverLogger.info("Отправлен ответ - " + t);
        } catch (IOException e) {
            serverLogger.error("Ошибка отправки ответ - " + e.getMessage());
        }
    }

    @Override
    public void run() {
        startProcessing();
    }
}
