package Client;

import models.Account;

import java.io.*;
import java.net.Socket;

public class Client {
    private Account account;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;


    public Client(Account account) {
        this.account = account;
        try {
            socket = new Socket("localhost",1111);
            output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            output.writeUTF(account.getUsername());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String login(String out){
        try {
            output.writeUTF(out);
            output.flush();
            return input.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
