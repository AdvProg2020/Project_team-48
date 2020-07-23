package Server;

import Client.Client;
import main.Main;
import models.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.AbstractCollection;

public class ClientHandler extends Thread{

    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;


    public ClientHandler(DataInputStream input, DataOutputStream output, Socket socket)   {
        this.input = input;
        this.output = output;
        this.socket = socket;

    }

    @Override
    public void run() {
        String receive;
        while (true){
            try {

                receive = input.readUTF();
                if (receive.startsWith("login")){
                    String username = receive.split("\\s")[1];
                    String password = receive.split("\\s")[2];
                    if (username.equals("") || password.equals("")) {
                        output.writeUTF("unfilled field exist");
                    } else if (!Account.existsUsername(username)) {
                        output.writeUTF("username does not exist" + Account.getAllAccounts());
                    } else if (Account.getUserByName(username) == null) {
                        output.writeUTF("invalid username");
                    } else if (Account.getUserByName(username).getPassword().equals(password)) {

                        output.writeUTF("logged in");
                        Server.addLoggedIn(Account.getUserByName(username));
                    } else {
                        output.writeUTF("invalid password");
                    }
                    output.flush();
                }else if (receive.startsWith("register manager")){
                    String username = receive.split("\\s")[2];
                    String password = receive.split("\\s")[3];
                    String name = receive.split("\\s")[4];
                    String familyName = receive.split("\\s")[5];
                    String email = receive.split("\\s")[6];
                    String phoneNumber = receive.split("\\s")[7];
                    if (username.equals("") || password.equals("") || name.equals("") || familyName.equals("") || email.equals("") || phoneNumber.equals("")) {
                        output.writeUTF("unfilled field exist");
                    } else {
                        Manager manager = new Manager(username);
                        manager.setFirstName(name);
                        manager.setLastName(familyName);
                        manager.setPassword(password);
                        manager.setEmail(email);
                        manager.setPhoneNumber(phoneNumber);
                        output.writeUTF("registered");
                    }
                    output.flush();
                }else if (receive.startsWith("register poshtiban")){
                    String username = receive.split("\\s")[2];
                    String password = receive.split("\\s")[3];
                    if (username.equals("") || password.equals("")) {
                        output.writeUTF("unfilled field exist");
                    } else {
                        output.writeUTF("registered");
                        Poshtiban poshtiban = new Poshtiban(username);
                        poshtiban.setPassword(password);
                    }
                    output.flush();
                }else if (receive.startsWith("register others")){
                    String username = receive.split("\\s")[2];
                    String password = receive.split("\\s")[3];
                    String name = receive.split("\\s")[4];
                    String familyName = receive.split("\\s")[5];
                    String email = receive.split("\\s")[6];
                    String phoneNumber = receive.split("\\s")[7];
                    String accountType = receive.split("\\s")[8];
                    String company = receive.split("\\s")[9];
                    if ((accountType.equals("seller") && company.equals("")) || accountType.equals("") || username.equals("") || password.equals("") || name.equals("") || familyName.equals("") || email.equals("") || phoneNumber.equals("")) {
                        output.writeUTF("unfilled field exist");
                    } else if (accountType.equals("buyer")) {
                        if (!Account.existsUsername(username)) {
                            Buyer buyer = new Buyer(username);
                            buyer.setFirstName(name);
                            buyer.setPassword(password);
                            buyer.setLastName(familyName);
                            buyer.setEmail(email);
                            buyer.setPhoneNumber(phoneNumber);
                            output.writeUTF("registered");
                        }
                    } else if (accountType.equals("seller")) {
                        if (!Account.existsUsername(username)) {
                            Seller seller = new Seller(username);
                            seller.setFirstName(name);
                            seller.setPassword(password);
                            seller.setLastName(familyName);
                            seller.setEmail(email);
                            seller.setPhoneNumber(phoneNumber);
                            seller.setOrganization(company);
                            output.writeUTF("registered");
                            new Request(seller, null, null);
                        }
                    } else {
                        output.writeUTF("invalid account type");
                    }
                    output.flush();
                }else if (receive.startsWith("logout")){
                    String username = receive.split("\\s")[1];
                    Server.removeLoggedIn(Account.getUserByName(username));
                }else if (receive.equals("online poshtiban")){
                    String s = "";
                    for (Account account : Server.getLoggedIn()) {
                        if(Poshtiban.getAll().contains(account)){
                            s = s.concat(account.getUsername());
                        }
                    }
                    output.writeUTF(s);
                    output.flush();
                }else if (receive.equals("loggedIn")){
                    String s = "";
                    for (Account account : Server.getLoggedIn()){
                        s = s.concat(account.getUsername());
                    }
                    output.writeUTF(s);
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
