package Server;

import models.Account;
import models.Buyer;
import models.Manager;
import models.Seller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream input ;
    private DataOutputStream output;
    private static ArrayList<Account> loggedIn= new ArrayList<>();



    public Server() {
        try {
           this.serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            Socket socket ;
            try {
                socket = serverSocket.accept();
                input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                output.writeUTF("accept");
                output.flush();
                Thread client = new ClientHandler(input, output, socket);
                client.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager("m");
        manager.setPassword("m");

        Buyer buyer = new Buyer("b");
        buyer.setPassword("b");

        Seller seller = new Seller("s");
        seller.setPassword("s");
        Server server = new Server();
    }

    public static void addLoggedIn(Account account) {
        loggedIn.add(account);
    }

    public static void removeLoggedIn(Account account) {
        loggedIn.remove(account);
    }

    public static ArrayList<Account> getLoggedIn() {
        return loggedIn;
    }
}
