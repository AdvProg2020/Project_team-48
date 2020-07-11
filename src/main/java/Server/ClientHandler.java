package Server;

import Client.Client;
import main.Main;
import models.Account;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{

    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Account account;


    public ClientHandler(DataInputStream input, DataOutputStream output, Socket socket)   {
        this.input = input;
        this.output = output;
        this.socket = socket;
        Account account = null;
        String accountName = null;
        try {
            accountName = input.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ((account = Account.getUserByName(accountName)) != null){
            this.account =account;
        }
    }

    @Override
    public void run() {
        String receive;
        while (true){
            try {
                Account account;
                receive = input.readUTF();
                if (receive.startsWith("login")){
                    String username = receive.split("\\s")[1];
                    String password = receive.split("\\s")[2];
                    if (username.equals("") || password.equals("")) {
                        output.writeUTF("unfilled field exist");
                    } else if (!Account.existsUsername(username)) {
                        output.writeUTF("username does not exist");
                    } else if (Account.getUserByName(username) == null) {
                        output.writeUTF("invalid username");
                    } else if (Account.getUserByName(username).getPassword().equals(password)) {
                        Main.setScene(Account.getUserByName(username).getAccountPage());
                        Main.setAccount(Account.getUserByName(username));
                        output.writeUTF("logged in");
                    } else {
                        output.writeUTF("invalid password");
                    }
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
