package models;

import java.util.ArrayList;

public class Seller extends Account {
    private String organization;
    private ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Seller> allSellers = new ArrayList<>();
    private ArrayList<Off> offs = new ArrayList<>();

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

    public ArrayList<Off> getOffs() {
        return offs;
    }

    public String getOrganization() {
        return organization;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void removeProduct(Product chosenProduct) {
        products.remove(chosenProduct);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addOff(Off off) {
        offs.add(off);
    }
}
