package models;

import java.util.ArrayList;
import java.util.Date;

enum AccountType{
    MANAGER,
    BUYER,
    SELLER
}

public class Account {

    public static ArrayList<Account> allAccounts = new ArrayList<>();

    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected int phoneNumber;
    protected Date lastLoggedIn;
    private AccountType accountType;
    private ArrayList<Off> offCodes;
    private ArrayList<SellLog> sellLogsList;
    private ArrayList<BuyLog> buyLogsList;
    private int credit;

    public Account(String username, String password, String firstName, String lastName, String email, int phoneNumber) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        allAccounts.add(this);
    }

    public Account getUserByName(String username){
        for(Account account : allAccounts){
            if(username.equals(account.username)){
                return account;
            }
        }
        return null;
    }

    public static boolean existsUsername(String username){
        for (Account account : allAccounts) {
            if (username.equals(account.username)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return "This is a" + this.accountType + "!!";
    }
}
