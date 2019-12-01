package com.company;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	String IP = "192.168.100.35";

	for (int start = 1; start <= 65536;start++){
        try {
            Socket socket = new Socket(IP,start);
            System.out.println(start + " is in LISTENING state!");
        } catch (IOException e) {
            System.out.println(start + " is NOT open!");
        }

    }
    }
}
