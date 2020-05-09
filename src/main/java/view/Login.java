package view;

import java.util.Scanner;

public class Login extends Page{
    public Login(Page parentPage){
        super(parentPage);
        this.name = "Login";
        subPages.put("back", new Back(this));
    }
}
