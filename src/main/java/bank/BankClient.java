package bank;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Pattern;

public class BankClient extends Thread {
    private DataOutputStream dataOut;
    private DataInputStream dataIn;
    private Socket socket;

    public BankClient(DataOutputStream dataOut, DataInputStream dataIn, Socket socket) {
        this.dataOut = dataOut;
        this.dataIn = dataIn;
        this.socket = socket;
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
            assert client != null;
            if (client.getPassword().equals(splitInput[1])){
                Token token = new Token(client);
                client.setToken(token);
            }
            else {
               dataOut.writeUTF("invalid username or password");
            }
        }
        dataOut.flush();
    }

    public void createReceipt(String input) throws IOException {
        String[] splitInput = input.substring("create_receipt ".length()).split(" ");
        if (!Pattern.matches("(deposit|move|withdraw)", splitInput[1]))
            dataOut.writeUTF("invalid receipt type");
        else if (!Pattern.matches("[\\d]+", splitInput[2]))
            dataOut.writeUTF("invalid money");
        else if (BankServer.getAccountByToken(splitInput[0]).getToken().isExpired())
            dataOut.writeUTF("token expired");
        else if ((splitInput[1].equals("move") || splitInput[1].equals("withdraw")) && BankServer.getAccountByAccountNumber(splitInput[3]) == null)
            dataOut.writeUTF("source account id is invalid");
        else if ((splitInput[1].equals("move") || splitInput[1].equals("withdraw")) &&
                (BankServer.getAccountByToken(splitInput[0]).getToken() == null || !BankServer.getAccountByToken(splitInput[0]).getUsername().equals(BankServer.getAccountByAccountNumber(splitInput[3]).getUsername())))
            dataOut.writeUTF("token is invalid");
        else if (splitInput[1].equals("move") && BankServer.getAccountByAccountNumber(splitInput[4]) == null)
            dataOut.writeUTF("dest account id is invalid");
        else if (splitInput[1].equals("move") && splitInput[3].equals(splitInput[4]))
            dataOut.writeUTF("equal source and dest account");
        else if (splitInput[1].equals("deposit") && BankServer.getAccountByToken(splitInput[0]) == null)
            dataOut.writeUTF("token is invalid");
        else if (splitInput[1].equals("deposit") && BankServer.getAccountByAccountNumber(splitInput[4]) == null)
            dataOut.writeUTF("dest account id is invalid");
        else if ((splitInput[1].equals("deposit") && !splitInput[3].equals("-1")) || (splitInput[1].equals("withdraw") && !splitInput[4].equals("-1")))
            dataOut.writeUTF("invalid account id");
        else {
            int pointer = 0;
            for(int i = input.length() - 1; i >= 0; i--) {
                if (input.charAt(i) == ' ') {
                    pointer = i;
                    break;
                }
            }
            String description = input.substring(pointer);
            if (!Pattern.matches("[\\w|\\s]*", description))
                dataOut.writeUTF("your input contains invalid characters");
            else {
                String id;
                Reciept reciept = new Reciept(splitInput[1], BankServer.getAccountByAccountNumber(splitInput[3]), BankServer.getAccountByAccountNumber(splitInput[4]) , Integer.parseInt(splitInput[2]));
                BankServer.allReciepts.add(reciept);
                dataOut.writeUTF(reciept.getRecieptId());
            }
        }
        dataOut.flush();
    }

    public void getTransactions(String input) throws IOException {
        String[] splitInput = input.substring("get_transactions ".length()).split(" ");
        if (BankServer.getAccountByToken(splitInput[0]) == null)
            dataOut.writeUTF("token is invalid");
        else if (BankServer.getAccountByToken(splitInput[0]).getToken().isExpired())
            dataOut.writeUTF("token expired");
        else if (!Pattern.matches("[*|+|-]", splitInput[1])) {
            if (BankServer.getRecieptById(splitInput[1]) == null)
                dataOut.writeUTF("invalid receipt id");
            else
                dataOut.writeUTF(BankServer.getRecieptById(splitInput[1]).toString());
        }
        else {
            String transactions = "";
            BankAccount bankClient = BankServer.getAccountByToken(splitInput[0]);
            if(splitInput[1].equals("*")){
                for(Reciept reciept : BankServer.allReciepts){
                    if((reciept.getSourceAccount() == bankClient || reciept.getDestinationAccount() == bankClient) && reciept.isPaid())
                        transactions += new Gson().toJson(reciept);
                }
            }
            else if (splitInput[1].equals("+")){
                for(Reciept reciept : BankServer.allReciepts){
                    if(reciept.getDestinationAccount() == bankClient && reciept.isPaid())
                        transactions += new Gson().toJson(reciept);
                }
            }
            else if (splitInput[1].equals("-")){
                for(Reciept reciept : BankServer.allReciepts){
                    if(reciept.getSourceAccount() == bankClient && reciept.isPaid())
                        transactions += new Gson().toJson(reciept);
                }
            }
            dataOut.writeUTF(transactions);
        }
        dataOut.flush();
    }

    public void pay(String input) throws IOException {
        String receiptId = input.substring("pay ".length());
        if (BankServer.getRecieptById(receiptId) == null)
            dataOut.writeUTF("invalid receipt id");
        else {
            Reciept reciept = BankServer.getRecieptById(receiptId);
            if (reciept.isPaid())
                dataOut.writeUTF("receipt is paid before");
            else if (reciept.getSourceAccount() != null && reciept.getSourceAccount().getMoney() < reciept.getValue())
                dataOut.writeUTF("source account does not have enough money");
            else if (BankServer.getAccountByUsername(reciept.getSourceAccount().getUsername()) == null
                    || BankServer.getAccountByAccountNumber(reciept.getDestinationAccount().getAccountNumber()) == null)
                dataOut.writeUTF("invalid account id");
            else {
                BankAccount sourceAccount = BankServer.getAccountByUsername(reciept.getSourceAccount().getUsername());
                BankAccount destinationAccount = BankServer.getAccountByUsername(reciept.getDestinationAccount().getUsername());
                sourceAccount.setMoney(sourceAccount.getMoney() - reciept.getValue());
                destinationAccount.setMoney(destinationAccount.getMoney() + reciept.getValue());
                dataOut.writeUTF("done successfully");
                reciept.payReciept();
            }
            dataOut.flush();
        }
    }

    public void getBalance(String input) throws IOException {
        String tokenString = input.substring("get_balance ".length());
        if (BankServer.getAccountByToken(tokenString) == null)
            dataOut.writeUTF("token is invalid");
        else if (BankServer.getAccountByToken(tokenString).getToken().isExpired())
            dataOut.writeUTF("token expired");
        else {
            dataOut.writeUTF("" + BankServer.getAccountByToken(tokenString).getMoney());
        }
        dataOut.flush();
    }

}