package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9090);

            boolean stop = false;

            while (!stop) {
                Socket socket = server.accept();
                ThreadClient client = new ThreadClient(socket);
                client.start();


            }
        }catch (IOException e){
            System.out.println("Port 9090 is already open! Try another port!");
        }catch (Exception e1){
            System.out.println(e1.toString());
        }
    }
}
