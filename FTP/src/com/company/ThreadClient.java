package com.company;

import java.io.*;
import java.net.Socket;

public class ThreadClient extends Thread {
    private Socket socket;
    private BufferedReader in;
    private BufferedOutputStream out;
    private BufferedInputStream fileReader;


    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedOutputStream(socket.getOutputStream());

            String fileName = in.readLine();
            System.out.println("File name " + fileName + " has been requested by: " + socket.getInetAddress().getHostAddress());
            File file = new File(fileName);

            if (!file.exists()){
                byte code = (byte) 0;
                out.write(code);
                closeConnection();
            }else {
                out.write((byte) 1);

                fileReader = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[1024];

                int bytesRead = 0;
                while ((bytesRead = fileReader.read(buffer)) != -1){
                    out.write(buffer,0,buffer.length);
                    out.flush();
                }
                closeConnection();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try
        {
            if(in!=null)
            {
                in.close();
            }
            if(fileReader!=null)
            {
                fileReader.close();
            }
            if(out!=null)
            {
                out.close();
                socket.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
