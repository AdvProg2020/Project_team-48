package view.usersPageCommands.BuyerCommands;

import models.BuyLog;
import models.Product;
import models.Rating;
import view.Back;
import view.Page;

public class ViewOrders extends Page {
    public ViewOrders(Page parentPage) {
        super(parentPage,"view orders");
        subPages.put("show order (\\d+)", ShowOrder());
        subPages.put("rate (\\d+) (1-5)", Rate());
    }

    @Override
    public void execute() {
        System.out.println(BuyLog.getLogCodeByAccount(Page.getAccount()));
        super.execute();
    }

    protected Page ShowOrder(){
        return new Page(this,"show order") {
            @Override
            public void execute() {
                System.out.println(BuyLog.getLogByCode(Integer.parseInt(parentPage.getMatcher().group(1))));
                new Back(this).execute();
            }
        };
    }

    protected Page Rate(){
        return new Page(this,"rate") {
            @Override
            public void execute() {
                if (BuyLog.hasProduct(Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))),Page.getAccount())) {
                    new Rating(Page.getAccount(), Integer.parseInt(parentPage.getMatcher().group(2)), Product.getProductById(Integer.parseInt(parentPage.getMatcher().group(1))));
                }else{
                    System.out.println("you have not bought this product");
                }
                new Back(this).execute();
            }
        };
    }
}