package bank;

import java.util.ArrayList;

public class BankServer {

    public static ArrayList<BankAccount> allBankAccounts = new ArrayList<>();

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
}
