package Client;

import models.Account;

import java.io.*;
import java.net.Socket;

public class Client {
    private Account account;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private Boolean connection;


    public Client() {

        try {
            socket = new Socket("localhost",6666);
            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
           if (input.readUTF().equals("accept")){
               connection = true;
               System.out.println("Client connected");
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sendCommand(String out)  {
        DataOutputStream  output = null;
        DataInputStream input = null;
        try {
            Socket socket = new Socket("localhost",6666);
            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            if (input.readUTF().equals("accept")){
                Boolean connection = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            output.writeUTF(out);
            output.flush();
            return input.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }

}
