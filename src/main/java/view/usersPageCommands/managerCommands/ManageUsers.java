package view.usersPageCommands.managerCommands;

import controller.ManagerControl;
import models.Account;
import view.Back;
import view.CreateAccount;
import view.Page;

public class ManageUsers extends Page {
    public ManageUsers( Page parentPage) {
        super(parentPage);
        this.name = "Manage Users";
        View().setName("View user");
        DeleteUser().setName("Delete user");
        CreateManagerProfile().setName("Create manager profile");
        subPages.put("view (\\S+)",View());
        subPages.put("delete user (\\S+)",DeleteUser());
        subPages.put("create manager profile",CreateManagerProfile());
        subPages.put("back", new Back(this) );
    }

    protected Page View(){
        return new Page(this) {
            @Override
            public void execute() {
               System.out.println( Account.getUserByName(parentPage.getMatcher().group()));
               new Back(this).execute();
            }
        };
    }

    protected Page DeleteUser(){
        return new Page(this) {
            @Override
            public void execute() {
                ManagerControl.deleteUser(parentPage.getMatcher().group(1));
                new Back(this).execute();
            }
        };
    }

    protected Page CreateManagerProfile(){
        return new Page(this) {
            @Override
            public void execute() {
                new CreateAccount(this).returnExceptions("manager",scanner.nextLine());
                new Back(this).execute();
            }
        };
    }

}
