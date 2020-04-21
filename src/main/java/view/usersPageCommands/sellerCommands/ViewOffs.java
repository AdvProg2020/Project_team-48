package view.usersPageCommands.sellerCommands;

import view.Page;

public class ViewOffs extends Page {
    public ViewOffs(Page parentPage) {
        super(parentPage);
        subPages.put("view\\s(\\S+)",View());
        subPages.put("edit\\s(\\S+)",Edit());
        subPages.put("add\\soff",AddOff());
    }

    protected Page View(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Edit(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page AddOff(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
