package controller;

import models.Account;

public class Manager {
    public static void deleteUser(String name){
        Account.remove(Account.getUserByName(name));
    }
}
