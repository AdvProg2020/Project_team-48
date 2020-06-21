package models;

import java.util.ArrayList;

public class Seller extends Account {
    private String organization;
    private ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Seller> allSellers = new ArrayList<>();

    public Seller(String username) {
        super(username);
        super.setAccountType(AccountType.SELLER);
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void add() {
        allSellers.add(this);
        Account.allAccounts.add(this);
    }

    public String getOrganization() {
        return organization;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
