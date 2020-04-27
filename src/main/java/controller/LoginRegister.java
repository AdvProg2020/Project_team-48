package controller;


import models.Account;

public class LoginRegister {
    public static void createAccount(String type,String username) {
         if (Account.existsUsername(username)){
            System.out.println(" ");
         }

    }
}
