package view;

import controller.LoginRegister;
import models.Account;
import models.Seller;

import java.util.HashMap;

public class LoginRegisterPage extends Page{
    public LoginRegisterPage(Page parentPage) {
        super(parentPage);
        this.name= "Login/Register Page";
        subPages.put("create account", new CreateAccount(this));
        subPages.put("login", new Login(this));
        subPages.put("back",new Back(this));
    }
}