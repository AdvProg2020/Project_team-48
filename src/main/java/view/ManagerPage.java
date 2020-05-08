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
        subPages.put("view personal info",new PersonalInfo(this));
        subPages.put("manage users",new ManageUsers(this));
        subPages.put("create discount code",CreateDiscountCode());
        subPages.put("manage requests",new ManageRequests(this));
        subPages.put("manage categories",new ManageCategories(this));
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
