package models;

import java.util.ArrayList;

public class Account {
    private String username;
    private static ArrayList<Account>  allAccounts = new ArrayList<>();

    public Account(String username) {
        this.username = username;
        allAccounts.add(this);
    }

    public static boolean existsUsername(String username){
        for (Account account : allAccounts) {
            if (username.equals(account.username)){
                return true;
            }
        }
        return false;
    }

}
