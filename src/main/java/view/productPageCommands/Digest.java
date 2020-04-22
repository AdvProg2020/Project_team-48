package view.productPageCommands;

import view.Page;

public class Digest extends Page {
    public Digest(Page parentPage) {
        super(parentPage);
        subPages.put("add\\sto\\scart",AddToCart());
        subPages.put("select\\sseller\\s(\\S+)",SelectSeller());

    }

    protected Page AddToCart(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page SelectSeller(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
