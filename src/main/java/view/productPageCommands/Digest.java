package view.productPageCommands;

import models.Buyer;
import view.Back;
import view.LoginRegisterPage;
import view.Page;

public class Digest extends Page {
    public Digest(Page parentPage) {
        super(parentPage, "digest");
        this.product = parentPage.getProduct();
        subPages.put("add to cart", AddToCart());
        subPages.put("select seller (\\S+)", SelectSeller());
    }

    @Override
    public void execute() {
        System.out.println(product.getPrice());
        System.out.println(product.getExisting());
        System.out.println(product.getRate());
        System.out.println(product.getCategory());
        super.execute();
    }

    protected Page AddToCart() {
        return new Page(this, "add to cart") {
            @Override
            public void execute() {
                if (Page.getAccount() == null) {
                    System.out.println("login first:");
                    new LoginRegisterPage(this).execute();
                } else {
                    Buyer buyer = (Buyer) Page.getAccount();
                    buyer.getCart().addProductToCart(product);
                    System.out.println("product added to cart successfully");
                    new Back(this).execute();
                }
            }
        };
    }

    protected Page SelectSeller() {
        return new Page(this, " select seller") {
            @Override
            public void execute() {

            }
        };
    }
}
