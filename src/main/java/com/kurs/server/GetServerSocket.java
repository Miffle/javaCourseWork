package com.kurs.server;

import lombok.Getter;

import java.io.IOException;
import java.net.ServerSocket;

@Getter
public class GetServerSocket {
    private final ServerSocket socket;

    public GetServerSocket() {
        try {
            socket = new ServerSocket(25565);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
