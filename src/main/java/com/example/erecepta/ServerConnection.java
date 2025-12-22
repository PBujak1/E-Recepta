package com.example.erecepta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnection {

    private static final String server = "localhost";
    private static final int port = 12345;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(server, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("GET_PACJENT");

            String response = in.readLine();
            System.out.println(response);

        } catch (IOException e) {
            System.out.println("Brak połączenia z serwerem");
        }
    }
}
