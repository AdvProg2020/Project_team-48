package view.usersPageCommands.managerCommands;

import controller.ManagerControl;
import models.Account;
import models.Manager;
import view.Back;
import view.CreateAccount;
import view.Page;

public class ManageUsers extends Page {
    public ManageUsers(Page parentPage) {
        super(parentPage,"Manage Users");
        subPages.put("view (\\S+)", View());
        subPages.put("delete user (\\S+)", DeleteUser());
        subPages.put("create manager profile", CreateManagerProfile());
        subPages.put("back", new Back(this));
    }

    protected Page View() {
        return new Page(this,"View") {
            @Override
            public void execute() {
                System.out.println(Account.getUserByName(parentPage.getMatcher().group(1)));
                new Back(this).execute();
            }
        };
    }

    protected Page DeleteUser() {
        return new Page(this,"Delete user") {
            @Override
            public void execute() {
                ManagerControl.deleteUser(parentPage.getMatcher().group(1));
                new Back(this).execute();
            }
        };
    }

    protected Page CreateManagerProfile() {
        return new Page(this,"Create manager profile") {
            @Override
            public void execute() {
                System.out.println("name:");
                Account account = Page.getAccount();
                String username;
                if (Account.existsUsername(username = scanner.nextLine())) {
                    System.out.println("username exists");
                }
                new Manager(username);
                new CreateAccount(this).getInfo(account, "manager");
                new Back(this).execute();
            }
        };
    }

}
