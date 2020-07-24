package bank;

import java.net.ServerSocket;
import java.util.ArrayList;

public class BankServer {

    public static ArrayList<BankAccount> allBankAccounts = new ArrayList<>();
    public static ArrayList<Reciept> allReciepts = new ArrayList<>();

    public static boolean isUsernameAvailable(String username){
        for(BankAccount bankAccount : allBankAccounts) {
            if (username.equals(bankAccount.getUsername())) {
                return false;
            }
        }
        return true;
    }

    public static BankAccount getAccountByUsername(String username){
        for(BankAccount bankAccount : allBankAccounts){
            if(username.equals(bankAccount.getUsername()))
                return bankAccount;
        }
        return null;
    }

    public static BankAccount getAccountByToken(String tokenString){
        for(BankAccount bankAccount : allBankAccounts) {
            if (tokenString.equals(bankAccount.getToken().getToken()))
                return bankAccount;
        }
        return null;
    }

    public static BankAccount getAccountByAccountNumber(String accountNumber){
        for(BankAccount bankAccount : allBankAccounts) {
            if (accountNumber.equals(bankAccount.getAccountNumber()))
                return bankAccount;
        }
        return null;
    }

    public static Reciept getRecieptById(String id){
        for(Reciept reciept : allReciepts){
            if(reciept.getRecieptId().equals(id))
                return reciept;
        }
        return null;
    }
}
