package com.kurs.client.controllers.startwindow;

import com.google.gson.Gson;
import com.kurs.protocols.Request;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SendRequest {
    public static String sendRequest(int requestID) {
        try (Socket socket = new Socket("localhost", 25565)) {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String s = new Gson().toJson(new Request(requestID));
            out.write(s + "\n");
            out.flush();
            return WaitResponse.waitResponse(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sendRequest(String request) {
        try (Socket socket = new Socket("localhost", 25565)) {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(request + "\n");
            out.flush();
            return WaitResponse.waitResponse(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
