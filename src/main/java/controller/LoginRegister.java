package controller;


import com.sun.tools.javac.Main;
import models.*;
import view.Back;
import view.Page;

import java.util.Scanner;

public class LoginRegister {

    public static Account createAccount(String type, String username) throws Exception {
        if (Account.existsUsername(username)) {
            throw new ExistUsernameException("username exists");
        }
        if (type.equals("manager")) {
            if (! Manager.getAllManagers().isEmpty()){
                throw new ExistManagerException("manager exist");
            }
            return new Manager(username);
        } else if (type.equals("seller")) {
            Seller seller = new Seller(username);
            new Request(seller);
            return seller;
        } else {
            return new Buyer(username);
        }
    }
    public static void login(Account account, Page page){
        if (page.getName().equals("Login/Register Page")){
            Page.setAccount(account);
            account.getAccountPage(page).execute();
        }else {
            ///vaghti az peyjaye dige miaymmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
        }

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