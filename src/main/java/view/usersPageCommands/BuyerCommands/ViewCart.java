package view.usersPageCommands.BuyerCommands;

import view.Page;

public class ViewCart extends Page {
    public ViewCart(Page parentPage) {
        super(parentPage);
        subPages.put("show\\sproducts",ShowProduct());
        subPages.put("view\\s(\\d+)",View());
        subPages.put("increase\\s(\\d+)",Increase());
        subPages.put("decrease\\s(\\d+)",Decrease());
        subPages.put("show\\stotal\\sprice",ShowTotalPrice());
        subPages.put("purchace",Purchase());
    }

    protected Page ShowProduct(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page View(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Increase(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Decrease(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ShowTotalPrice(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Purchase(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}


