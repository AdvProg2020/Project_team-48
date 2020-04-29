package view;

import controller.LoginRegister;
import models.Account;

import java.util.HashMap;

public class LoginRegisterPage extends Page{
    public LoginRegisterPage( Page parentPage) {
        super(parentPage);
        this.name= "login or register";
        subPages.put("create account (manager|seller|buyer) (\\S+)",createAccount());
        subPages.put("login (\\S+)",login());
        subPages.put("back",new Back(this));
    }

    protected Page createAccount(){
        return new Page(this) {
            @Override
            public void execute() {
                Account account = null;
                try {
                    account = LoginRegister.createAccount(parentPage.getMatcher().group(1),parentPage.getMatcher().group(2));
                } catch (Exception e) {
                    System.out.println("username exist");
                    new Back(this).execute();
                }
                System.out.println("password:");
                account.setPassword(scanner.nextLine());
                new Back(this).execute();
            }
        };
    }

    protected Page login(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }


}
