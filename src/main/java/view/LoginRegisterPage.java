package view;

import java.util.HashMap;

public class LoginRegisterPage extends Page{
    public LoginRegisterPage( Page parentPage) {
        super(parentPage);
        HashMap<String,Page> subPages = new HashMap<String, Page>();
        subPages.put("create\\saccount\\s(\\S+)\\s+(\\S+)",createAccount());
        subPages.put("login\\s(\\S+)",login());
        subPages.put("back",new Back(this));
    }

    protected Page createAccount(){
        return new Page(this) {
            @Override
            public void execute() {

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
