package view.usersPageCommands.managerCommands;

import view.Page;

public class ManageCategories extends Page {
    public ManageCategories(Page parentPage) {
        super(parentPage);
        subPages.put("edit\\s(\\S+)", Edit());
        subPages.put("add\\s(\\S+)",Add());
        subPages.put("remove\\s(\\s+)",Remove());

    }

    protected Page Edit(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Add(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Remove(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
