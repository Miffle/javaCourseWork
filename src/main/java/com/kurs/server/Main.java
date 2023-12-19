package com.kurs.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private final static ServerSocket socket = new GetServerSocket().getSocket();
    private static final Logger serverLogger = Logger.getLogger("server");

    public static void main(String[] args) {
        waitingConnections();
    }

    private static void waitingConnections() {
        while (true) {
            try {
                Socket socket1 = socket.accept();
                serverLogger.info("Опа, новое подключение");
                new Thread(new RequestHandler(socket1)).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
