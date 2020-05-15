package view;

import controller.LoginRegister;
import models.Account;
import models.Seller;
import java.util.HashMap;

public class LoginRegisterPage extends Page{



    public LoginRegisterPage(Page parentPage) {
        super(parentPage,"login/register Page");
        subPages.put("create account (manager|seller|buyer) (\\S+)", new CreateAccount(this));
        subPages.put("login (\\S+)", new Login(this));
        subPages.put("back",new Back(this));
        setLoginRegisterPage(parentPage);
    }
}