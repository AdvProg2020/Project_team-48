package models;

import java.util.ArrayList;
import java.util.Date;

enum AccountType {
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
    protected String phoneNumber;
    protected String address;
    protected Date lastLoggedIn;
    private AccountType accountType;
    private ArrayList<SellLog> sellLogsList = new ArrayList<>();
    private ArrayList<BuyLog> buyLogsList = new ArrayList<>();
    private Wallet wallet;
    protected ArrayList<Discount> allDiscounts = new ArrayList<>();

    public Account(String username) {
        this.username = username;
        this.wallet = new Wallet(this);
        this.setCredit(0);
    }


    public ArrayList<Discount> getAllDiscounts() {
        return allDiscounts;
    }

    public void removeDiscount(Discount discount) {
        allDiscounts.remove(discount);
    }

    public void setCredit(int credit) {
        this.wallet.setCredit(credit);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCredit() {
        return this.wallet.getCredit();
    }

    public static Account getUserByName(String username) {
        for (Account account : allAccounts) {
            if (username.equals(account.username)) {
                return account;
            }
        }
        return null;
    }

    public static boolean existsUsername(String username) {
        for (Account account : allAccounts) {
            if (username.equals(account.username)) {
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountPage() {
        switch (accountType) {
            case BUYER:
                return "BuyerPage";
            case MANAGER:
                return "ManagerPage";
            default:
                return "SellerPage";
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
                        "firstName= " + firstName + "\n" +
                        "lastName= " + lastName + "\n" +
                        "email= " + email + "\n" +
                        "phoneNumber= " + phoneNumber
                ;
    }

    public static void remove(Account account) {
        allAccounts.remove(account);
    }

    public ArrayList<SellLog> getSellLogsList() {
        return sellLogsList;
    }

    public ArrayList<BuyLog> getBuyLogList() {
        return buyLogsList;
    }

    public void addSellLog(SellLog sellLog) {
        sellLogsList.add(sellLog);
    }

    public void addBuyLog(BuyLog buyLog) {
        buyLogsList.add(buyLog);
    }
}
