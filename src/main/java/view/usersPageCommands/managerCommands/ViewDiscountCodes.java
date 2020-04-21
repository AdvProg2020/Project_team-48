package view.usersPageCommands.managerCommands;

import view.Page;

public class ViewDiscountCodes extends Page {
    public ViewDiscountCodes(Page parentPage) {
        super(parentPage);
        subPages.put("view\\sdiscount\\scode\\s(\\S+)",ViewDiscountCode());
        subPages.put("edit\\sdiscount\\scode\\s(\\S+)",EditDiscountCode());
        subPages.put("remove\\sdiscount\\scode\\s(\\S+)",RemoveDiscountCode());

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
