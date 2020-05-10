package view.usersPageCommands.managerCommands;

import view.Page;

public class ViewDiscountCodes extends Page {
    public ViewDiscountCodes(Page parentPage) {
        super(parentPage);
        subPages.put("view discount code (\\S+)",ViewDiscountCode());
        subPages.put("edit discount code (\\S+)",EditDiscountCode());
        subPages.put("remove discount code (\\S+)",RemoveDiscountCode());
    }

    protected Page ViewDiscountCode(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page EditDiscountCode(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page RemoveDiscountCode(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
