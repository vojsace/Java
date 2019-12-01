package com.company;

import java.io.*;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String ipAddress = "";
            String fileName = "";

            boolean isValid = false;

            while (!isValid) {
                System.out.println("Please enter a valid IP Address:");
                ipAddress = in.readLine();
                isValid = true;
            }

            System.out.println("Please enter a file name:");
            fileName = in.readLine();

            Socket socket = new Socket(ipAddress,9090);
            InputStream inputByte = socket.getInputStream();
            BufferedInputStream input = new BufferedInputStream(inputByte);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            out.println(fileName);

            int code = input.read();
            if (code == 1){
                BufferedOutputStream outputFile = new BufferedOutputStream(new FileOutputStream("D\\downloads\\" + fileName));
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while((bytesRead = input.read(buffer)) != -1){
                    System.out.println(".");
                    outputFile.write(buffer, 0, bytesRead);
                    outputFile.flush();
                }
                System.out.println();
                System.out.println("File " + fileName + " was sucessfully downloaded!");
            }
            else {
                System.out.println("File is not present on the server!");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }

}
