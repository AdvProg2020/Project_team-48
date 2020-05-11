package models;

import view.*;
import view.usersPageCommands.managerCommands.ManageAllProducts;

import java.util.ArrayList;
import java.util.Date;

enum AccountType{
    MANAGER,
    BUYER,
    SELLER
}
 
public class Account {

    public static ArrayList<Account> allAccounts = new ArrayList<>();
    public static boolean isAUserLoggedIn = false;

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

    public Account(String username) {
        this.username = username;
    }

    public static Account getUserByName(String username){
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Page getAccountPage(Page page) {
        switch (accountType)
        {
            case SELLER: return new SellerPage(page);
            case BUYER: return new BuyerPage(page);
            case MANAGER: return new ManagerPage(page);
            default: return page;
        }
    }

    public static ArrayList<Account> getAllAccounts() {
        return allAccounts;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return
                "username= " + username + "\n" +
                "password= " + password + "\n" +
                "firstName= " + firstName + "\n" +
                "lastName= " + lastName + "\n" +
                "email= " + email + "\n" +
                "phoneNumber= " + phoneNumber
                ;
    }

    public static void remove(Account account){
        allAccounts.remove(account);
    }

}
