package bank;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Pattern;

public class BankClient extends Thread {
    private DataOutputStream dataOut;
    private DataInputStream dataIn;
    private Socket socket;
    private BankServer bank;

    public BankClient(DataOutputStream dataOut, DataInputStream dataIn, Socket socket, BankServer bank) {
        this.dataOut = dataOut;
        this.dataIn = dataIn;
        this.socket = socket;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = dataIn.readUTF();
                if (Pattern.matches("create_account [\\S]+ [\\S]+ [\\S]+ [\\S]+ [\\S]+", input))
                    createAccount(input);
                else if (Pattern.matches("get_token [\\S]+ [\\S]+", input))
                    getToken(input);
                else if (Pattern.matches("create_receipt [\\S]+ [\\S]+ [\\S]+ [\\S]+ [\\S]+ .*", input))
                    createReceipt(input);
                else if (Pattern.matches("get_balance [\\S]+", input))
                    getBalance(input);
                else if (Pattern.matches("pay [\\d]+", input))
                    pay(input);
                else if (Pattern.matches("get_transactions [\\S]+ .+", input))
                    getTransactions(input);
                else if (input.equals("exit")) {
                    dataOut.writeUTF("disconnected successfully");
                    dataOut.flush();
                    socket.close();
                    System.out.println("client disconnected");
                    break;
                } else {
                    dataOut.writeUTF("invalid input");
                    dataOut.flush();
                }
            } catch (IOException e) {
                System.err.println("Something in connecting process happened...");
            }
        }
    }

    public void createAccount(String input) throws IOException {
        String[] splitInput = input.substring("create_account ".length()).split(" ");
        if (!splitInput[3].equals(splitInput[4]))
            dataOut.writeUTF("passwords do not match");
        else if (!BankServer.isUsernameAvailable(splitInput[2]))
            dataOut.writeUTF("username is not available");
        else {
            BankAccount newClient = new BankAccount(splitInput[0], splitInput[1] , splitInput[2], splitInput[3]);
            dataOut.writeUTF(newClient.getAccountNumber());
        }
        dataOut.flush();
    }

    public void getToken(String input) throws IOException {
        String[] splitInput = input.substring("get_token ".length()).split(" ");
        if (BankServer.isUsernameAvailable(splitInput[0]))
            dataOut.writeUTF("this username doesn't have account");
        else {
            BankAccount client = BankServer.getAccountByUsername(splitInput[0]);
            if (client.getPassword().equals(splitInput[1])){
                Token token = new Token(client);
                client.setToken(token);
            }
            else {
               dataOut.writeUTF("Password is invalid");
            }
        }
        dataOut.flush();
    }

    public void createReceipt(String input)  {

    }

    public void getBalance(String input) {

    }

    public void pay(String input) {

    }

    public void getTransactions(String input) {

    }
}
