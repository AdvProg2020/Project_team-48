package view;

import java.util.Scanner;

public class CreateAccount extends Page{
    public CreateAccount(Page parentPage){
        super(parentPage);
        this.name = "Create Account";
        subPages.put("back", new Back(this));
    }
}
