package models;

import java.util.ArrayList;

public class Buyer extends Account {
    private Cart cart;
    private ArrayList<BuyLog> buyLogs = new ArrayList<>();

    public Buyer(String username) {
        super(username);
        super.setAccountType(AccountType.BUYER);
        allAccounts.add(this);
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void addBuyLog(BuyLog buyLog) {
        buyLogs.add(buyLog);
    }

    public ArrayList<BuyLog> getBuyLogs() {
        return buyLogs;
    }
}
