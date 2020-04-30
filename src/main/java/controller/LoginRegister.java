package controller;


import com.sun.tools.javac.Main;
import models.Account;
import models.Buyer;
import models.Manager;
import models.Seller;
import view.Back;
import view.Page;

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
            return new Seller(username);
        } else {
            return new Buyer(username);
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

    public static void login(Account account, Page page){
        account.getAccountPage(page).execute();
    }




}
