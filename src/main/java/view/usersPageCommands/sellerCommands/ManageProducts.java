package view.usersPageCommands.sellerCommands;

import view.Page;

public class ManageProducts extends Page {
    public ManageProducts(Page parentPage) {
        super(parentPage,"manage products");
        subPages.put("view\\s(\\S+)",View());
        subPages.put("view\\sbuyers\\s(\\S+)",ViewBuyers());
        subPages.put("edit\\s(\\S+)",Edit());
    }

    protected Page View(){
        return new Page(this,"view") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ViewBuyers(){
        return new Page(this,"view buyers") {
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
}
