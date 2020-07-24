package bank;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Arrays;

public class Token {
    String token;
    BankAccount bankAccount;
    LocalTime staringTime;
    LocalTime endingTime;

    public Token(BankAccount bankAccount){
        this.token = generateToken();
        this.bankAccount = bankAccount;
        this.staringTime = LocalTime.now();
        this.endingTime = (this.staringTime).plusHours(1);
    }

    public String getToken() {
        return token;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public LocalTime getStaringTime() {
        return staringTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public boolean isExpired(){
        return !(this.endingTime).isAfter(LocalTime.now());
    }

    private String generateToken(){
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        return Arrays.toString(bytes);
    }

}
