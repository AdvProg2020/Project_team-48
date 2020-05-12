package view.usersPageCommands.sellerCommands;

import view.Page;

public class ViewOffs extends Page {
    public ViewOffs(Page parentPage) {
        super(parentPage,"view offs");
        subPages.put("view\\s(\\S+)",View());
        subPages.put("edit\\s(\\S+)",Edit());
        subPages.put("add\\soff",AddOff());
    }

    protected Page View(){
        return new Page(this,"view") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Edit(){
        return new Page(this,"edit") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page AddOff(){
        return new Page(this,"add off") {
            @Override
            public void execute() {

            }
        };
    }
}
