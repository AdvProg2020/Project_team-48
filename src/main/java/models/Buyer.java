package models;

public class Buyer extends Account {

    public Buyer(String username) {
        super(username);
        super.setAccountType(AccountType.BUYER);
        allAccounts.add(this);
    }
}
