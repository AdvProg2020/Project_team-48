package view.usersPageCommands.managerCommands;

import models.Account;
import models.Manager;
import models.Request;
import view.Back;
import view.Page;

public class ManageRequests extends Page {
    public ManageRequests(Page parentPage) {
        super(parentPage);
        this.name = "Manage requests";
        Details().setName("Details");
        Accept().setName("Accept");
        Decline().setName("Decline");
        subPages.put("details (\\S+)",Details());
        subPages.put("accept (\\S+)", Accept());
        subPages.put("decline (\\S+)", Decline());
    }

    @Override
    public void execute() {
        Manager manager = (Manager) getAccount();
        for (Request request : manager.getAllRequests()) {
            System.out.println(request.getRequestId());
        }
        super.execute();
    }

    protected Page Details(){
        return new Page(this) {
            @Override
            public void execute() {
                System.out.println(Request.getRequestById(Integer.parseInt(parentPage.getMatcher().group())));
                new Back(this).execute();
            }
        };
    }

    protected Page Accept(){
        return new Page(this) {
            @Override
            public void execute() {
                Request.acceptRequest(Integer.parseInt(parentPage.getMatcher().group()));
                new Back(this).execute();
            }
        };
    }

    protected Page Decline(){
        return new Page(this) {
            @Override
            public void execute() {
                Request.remove(Integer.parseInt(parentPage.getMatcher().group()));
                new Back(this).execute();
            }
        };
    }
}
