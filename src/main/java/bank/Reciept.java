package bank;

import java.util.Random;

public class Reciept {
    String recieptId;
    String recieptType;
    BankAccount sourceAccount;
    BankAccount destinationAccount;
    int value;
    boolean isPaid;

    public Reciept(String recieptType, BankAccount sourceAccount, BankAccount destinationAccount, int value) {
        this.recieptId = generateRecipetId();
        this.recieptType = recieptType;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.isPaid = false;
        BankServer.allReciepts.add(this);
    }

    public String getRecieptId() {
        return recieptId;
    }

    public String getRecieptType() {
        return recieptType;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    public int getValue() {
        return value;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payReciept(){
        this.isPaid = true;
    }

    private String generateRecipetId(){
        Random rnd = new Random();
        char[] digits = new char[10];
        for(int i = 0; i < 10; i++)
            digits[i] = (char) (rnd.nextInt(10) + '0');
        return new String(digits);
    }

    @Override
    public String toString(){
        return "{\"reciept_id\":" + recieptId
                + "\n,\"reciept_type\":" + recieptType
                + "\n,\"value\":" + Integer.toString(value)
                + "\n,\"source_account\":" + sourceAccount
                + "\n,\"destination_account\":" + destinationAccount
                + "\n,\"isPaid\":" + isPaid;
    }
}
