package view;

import controller.LoginRegister;

import java.util.HashMap;

public class LoginRegisterPage extends Page{
    public LoginRegisterPage( Page parentPage) {
        super(parentPage);
        subPages.put("create\\saccount\\s([manager|seller|buyer])\\s+(\\S+)",createAccount());
        subPages.put("login\\s(\\S+)",login());
        subPages.put("back",new Back(this));
    }

    protected Page createAccount(){
        return new Page(this) {
            @Override
            public void execute() {
                try {
                    LoginRegister.createAccount(parentPage.getMatcher().group(1),parentPage.getMatcher().group(2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
