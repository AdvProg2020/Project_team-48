package view;

import controller.LoginRegister;
import models.Account;

import java.util.Scanner;

public class Login extends Page{
    public Login(Page parentPage){
        super(parentPage,"login");
        subPages.put("back", new Back(this));
    }

    @Override
    public void execute() {
        login(parentPage.getMatcher().group(1));
    }

    public void login(String string){
        Account account = Account.getUserByName(string) ;
        if (account == null){
            System.out.println("username does not exist");
            new Back(this).execute();
        }else{
            System.out.println("password:");
            if(account.getPassword().equals(Page.scanner.nextLine())){
                LoginRegister.login(account,this.parentPage);
            }else {
                System.out.println("password is wrong");
                new Back(this).execute();
            }
        }

    }
}
