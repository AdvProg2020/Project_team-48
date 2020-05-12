package view.usersPageCommands.BuyerCommands;

import view.Page;

public class ViewCart extends Page {
    public ViewCart(Page parentPage) {
        super(parentPage,"view cart");
        subPages.put("show products",ShowProduct());
        subPages.put("view [productId]",View());
        subPages.put("increase [productId]",Increase());
        subPages.put("decrease [productId]",Decrease());
        subPages.put("show total price",ShowTotalPrice());
        subPages.put("purchase",Purchase());
    }

    protected Page ShowProduct(){
        return new Page(this,"show product") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page View(){
        return new Page(this,"view") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Increase(){
        return new Page(this, "increase") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Decrease(){
        return new Page(this,"decrease") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ShowTotalPrice(){
        return new Page(this,"show total price") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page Purchase(){
        return new Page(this,"purchase") {
            @Override
            public void execute() {

            }
        };
    }
}


