package view.usersPageCommands.BuyerCommands;

import view.Page;

public class ViewCart extends Page {
    public ViewCart(Page parentPage) {
        super(parentPage);
        subPages.put("show products",ShowProduct());
        subPages.put("view [productId]",View());
        subPages.put("increase [productId]",Increase());
        subPages.put("decrease [productId]",Decrease());
        subPages.put("show total price",ShowTotalPrice());
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


