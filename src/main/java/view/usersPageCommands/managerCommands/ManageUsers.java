package view.usersPageCommands.managerCommands;

import controller.Manager;
import view.Back;
import view.Page;

public class ManageUsers extends Page {
    public ManageUsers( Page parentPage) {
        super(parentPage);
        subPages.put("view (\\S+)",View());
        subPages.put("delete user (\\S+)",DeleteUser());
        subPages.put("create manager profile",CreateManagerProfile());
        subPages.put("back", new Back(this) );
    }

    protected Page View(){
        return new Page(this) {
            @Override
            public void execute() {
                // innnnnnn chiiiiiiiiiiiii kar mikoneeeeeeeeeeeeeeeeeeeeeeeeeee
            }
        };
    }

    protected Page DeleteUser(){
        return new Page(this) {
            @Override
            public void execute() {
                Manager.deleteUser(parentPage.getMatcher().group(1));
                new Back(this).execute();
            }
        };
    }

    protected Page CreateManagerProfile(){
        return new Page(this) {
            @Override
            public void execute() {
                //bad az zadane register iinam bezannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
            }
        };
    }

}
