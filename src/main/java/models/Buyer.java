package models;

public class Buyer extends Account {
    private Cart cart;

    public Buyer(String username) {
        super(username);
        super.setAccountType(AccountType.BUYER);
        allAccounts.add(this);
    }

    public Cart getCart() {
        return cart;
    }
}
