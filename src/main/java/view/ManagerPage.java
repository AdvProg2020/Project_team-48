package view;

import view.usersPageCommands.managerCommands.ManageCategories;
import view.usersPageCommands.managerCommands.ManageRequests;
import view.usersPageCommands.managerCommands.ManageUsers;
import view.usersPageCommands.PersonalInfo;
import java.util.HashMap;

public class ManagerPage extends Page{
    public ManagerPage(Page parentPage) {
        super(parentPage);
        this.name = "your account";
        subPages.put("view\\spersonal\\sinfo",new PersonalInfo(this));
        subPages.put("manage\\susers",new ManageUsers(this));
        subPages.put("create\\sdiscount\\scode",CreateDiscountCode());
        subPages.put("Manage\\srequests",new ManageRequests(this));
        subPages.put("manage\\scategories",new ManageCategories(this));
        subPages.put("back",new Back(this));
    }

    protected Page CreateDiscountCode(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }


}
