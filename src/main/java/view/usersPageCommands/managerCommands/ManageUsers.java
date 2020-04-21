package view.usersPageCommands.managerCommands;

import view.Page;

public class ManageUsers extends Page {
    public ManageUsers( Page parentPage) {
        super(parentPage);
        subPages.put("view\\s(\\S+)",View());
        subPages.put("delete\\suser\\s(\\S+)",DeleteUser());
        subPages.put("create\\smanager\\sprofile",CreateManagerProfile());
    }

    protected Page View(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page DeleteUser(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page CreateManagerProfile(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

}
