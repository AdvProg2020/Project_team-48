package models;

public class Wallet {
    private int credit;
    private Account account;


    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public Wallet(Account account) {
        this.account = account;
    }
}
