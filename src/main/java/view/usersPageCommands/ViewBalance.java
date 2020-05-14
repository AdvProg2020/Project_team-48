package view.usersPageCommands;

import view.Back;
import view.Page;

public class ViewBalance extends Page{
    public ViewBalance(Page page) {
        super(page,"view balance");
    }

    @Override
    public void execute() {
        System.out.println( Page.getAccount().getCredit());
        new Back(this).execute();
    }
}
