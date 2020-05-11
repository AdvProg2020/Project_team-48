package models;

import java.util.ArrayList;

public class Seller extends Account{
    private String organization;
    private static ArrayList<Seller> allSellers = new ArrayList<>();

    public Seller(String username) {
        super(username);
        super.setAccountType(AccountType.SELLER);
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void add(){
        allSellers.add(this);
    }
}
