package view.usersPageCommands.managerCommands;

import view.Page;

public class ManageAllProducts extends Page {
    public ManageAllProducts(Page parentPage) {
        super(parentPage);
        subPages.put("remove (\\S+)",Remove());
    }

    protected Page Remove(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
