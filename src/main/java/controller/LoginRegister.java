package controller;


import models.Account;
import models.Buyer;
import models.Manager;
import models.Seller;
import view.Back;
import view.Page;

public class LoginRegister {
    public static Account createAccount(String type, String username) throws Exception {
        if (Account.existsUsername(username)) {
            throw new Exception();
        }
        if (type.equals("manager")) {
            return new Manager(username);
        } else if (type.equals("seller")) {
            return new Seller(username);
        } else {
            return new Buyer(username);
        }

    }
}
