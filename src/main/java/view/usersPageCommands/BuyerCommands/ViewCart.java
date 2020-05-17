package view.usersPageCommands.BuyerCommands;

import models.Buyer;
import models.Product;
import view.Back;
import view.Page;

public class ViewCart extends Page {
    public ViewCart(Page parentPage) {
        super(parentPage,"view cart");
        subPages.put("show products",ShowProduct());
        subPages.put("view (\\d+)",View());
        subPages.put("increase (\\d+)",Increase());
        subPages.put("decrease (\\d+)",Decrease());
        subPages.put("show total price",ShowTotalPrice());
        subPages.put("purchase",new Purchase(this));
    }

    protected Page ShowProduct(){
        return new Page(this,"show product") {
            @Override
            public void execute() {
               Buyer buyer= (Buyer)Page.getAccount();
                for (Product product : buyer.getCart().getProducts()) {
                    System.out.println(product);
                }
                new Back(this).execute();
            }
        };
    }

    protected Page View(){
        return new Page(this,"view") {
            @Override
            public void execute() {
                Buyer buyer= (Buyer)Page.getAccount();
                if (buyer.getCart().getProducts().contains(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))))) {
                    System.out.println(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))));
                }else{
                    System.out.println("product does not exist in your cart");
                }
                new Back(this).execute();
            }
        };
    }

    protected Page Increase(){
        return new Page(this, "increase") {
            @Override
            public void execute() {
                Buyer buyer= (Buyer)Page.getAccount();
                buyer.getCart().changeAmountOfProduct(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))),-1);
                new Back(this).execute();
            }
        };
    }

    protected Page Decrease(){
        return new Page(this,"decrease") {
            @Override
            public void execute() {
                Buyer buyer= (Buyer)Page.getAccount();
                buyer.getCart().changeAmountOfProduct(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))),1);
                new Back(this).execute();
            }
        };
    }

    protected Page ShowTotalPrice(){
        return new Page(this,"show total price") {
            @Override
            public void execute() {
                Buyer buyer= (Buyer)Page.getAccount();
                System.out.println(buyer.getCart().getTotalPrice());
                new Back(this).execute();
            }
        };
    }

}


