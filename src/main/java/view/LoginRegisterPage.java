package view;

import java.util.HashMap;

public class LoginRegisterPage extends Page{
    public LoginRegisterPage( Page parentPage) {
        super("Login/Register Page", parentPage);
        HashMap<String,Page> subPages = new HashMap<String, Page>();
        subPages.put("create \\s account \\s (\\w+) \\s+ (\\S+)",createAccount());
        subPages.put("login \\s (\\S+)",login());
    }

    protected Page createAccount(){
        return new Page("create account",this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page login(){
        return new Page("login",this) {
            @Override
            public void execute() {

            }
        };
    }


}
