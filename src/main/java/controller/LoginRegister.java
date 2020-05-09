package controller;


import com.sun.tools.javac.Main;
import models.Account;
import models.Buyer;
import models.Manager;
import models.Seller;
import view.Back;
import view.Page;

import java.util.Scanner;

public class LoginRegister {

    public static void createAccount() {
        Scanner input = new Scanner(System.in);
        String username = input.next();
        String password = input.next();
        String type = input.next();
        System.out.println("User registered successfully(alaki masalan!)");
    }
    public static void login(){
        Scanner input = new Scanner(System.in);
        String username = input.next();
        String password = input.next();
        System.out.println("User logged in successfully(alaki masalan!)");
    }

    public static class ExistManagerException extends Exception{
        public ExistManagerException(String message) {
            super(message);
        }
    }

    public static class ExistUsernameException extends Exception{
        public ExistUsernameException(String message) {
            super(message);
        }
    }

}