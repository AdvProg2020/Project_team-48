package view.usersPageCommands.managerCommands;

import view.Page;

public class ManageRequests extends Page {
    public ManageRequests(Page parentPage) {
        super(parentPage);
        subPages.put("details\\s(\\S+)",Details());
        subPages.put("accept\\s(\\S+)", Accept());
        subPages.put("decline\\s(\\S+)", Decline());
    }

    protected Page Details(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Accept(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Decline(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
