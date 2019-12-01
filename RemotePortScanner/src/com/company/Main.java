package com.company;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(in);

        String targetIp = "";
        int fromPort = 0;
        int toPort = 0;

        System.out.print("Enter a target IP address: ");
        try {
            targetIp = input.readLine();
        }
        catch(Exception e) {
            System.out.println("Cannot read the IP address! " + e.toString());
        }

        boolean isValid = false;

        while(!isValid){
            try {
                System.out.print("Enter the first port: ");
                String read = input.readLine();
                fromPort = Integer.parseInt(read);
                if (fromPort >= 0 && fromPort <= 65536){
                    isValid = true;
                } else {
                    System.out.println("Invalid port! Port range is 0 - 65536.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Please enter a number! ");
            }catch(Exception e1) {
                System.out.println("Cannot read the first port number! " + e1.toString());
            }
        }

        isValid = false;
        while(!isValid){
            try {
                System.out.print("Enter the last port: ");
                String read = input.readLine();
                toPort = Integer.parseInt(read);
                if (toPort >= 0 && toPort <= 65536){
                    if (toPort >= fromPort) {
                        isValid = true;
                    }
                } else {
                    System.out.println("Invalid port! Port range is 0 - 65536.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Please enter a number! ");
            }catch(Exception e1) {
                System.out.println("Cannot read the first port number! " + e1.toString());
            }
        }

        int port = fromPort;
        while (port >= fromPort && port <= toPort){
            try {
                Socket socket = new Socket(targetIp, port);
                System.out.println("Port " + port + " is in listeningg state!");
                socket.close();
            }
            catch(UnknownHostException e) {
                System.out.println("Unknown host exception " + e.toString());
            }catch(IOException e1) {
                System.out.println("Port " + port + " is NOT open!");
            }catch(Exception e2) {
                System.out.println(e2.toString());
            }
            port++;
        }




    }
}
