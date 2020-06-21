package view;


public class LoginRegisterPage extends Page {


    public LoginRegisterPage(Page parentPage) {
        super(parentPage, "login/register page");
        subPages.put("create account (manager|seller|buyer) (\\S+)", new CreateAccount(this));
        subPages.put("login (\\S+)", new Login(this));
        setLoginRegisterPage(parentPage);
    }
}