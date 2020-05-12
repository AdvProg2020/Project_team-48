package view.productPageCommands;

import view.Page;

public class Digest extends Page {
    public Digest(Page parentPage) {
        super(parentPage,"digest");
        subPages.put("add to cart",AddToCart());
        subPages.put("select seller [seller_username]",SelectSeller());

    }

    protected Page AddToCart(){
        return new Page(this,"add to cart") {
            @Override
            public void execute() {

            }
        };
    }

    protected Page SelectSeller(){
        return new Page(this, " select seller") {
            @Override
            public void execute() {

            }
        };
    }
}
