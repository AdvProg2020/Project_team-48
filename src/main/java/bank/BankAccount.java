package bank;

import java.time.LocalDate;

public class BankAccount {
    String firstName;
    String lastName;
    String accountNumber;
    String username;
    String password;
    Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    LocalDate expirationDate;
    int deposit;

    public BankAccount(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = generateAccountNumber();
        this.username = username;
        this.password = password;
        this.token = null;
        this.expirationDate = LocalDate.now().plusYears(3);
        this.deposit = 0;
    }

    public String getUsername() {return this.username;}

    public String getPassword() {
        return this.password;
    }

    public synchronized long getMoney() {
        return this.deposit;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public synchronized void setMoney(int money) {
        this.deposit = money;
    }

    public boolean isValid(String accountNumber, String password){
        return accountNumber.equals(this.accountNumber) && password.equals(this.password);
    }

    private String generateAccountNumber(){
        String accountNum = "";
        for(int i = 0; i < 16; i++)
            accountNum.concat(Integer.toString(((int)Math.random())%10));
        return accountNum;
    }

}
