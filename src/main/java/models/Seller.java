package models;

public class Seller extends Account{
    private String organization;

    public Seller(String username) {
        super(username);
        super.setAccountType(AccountType.SELLER);
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
