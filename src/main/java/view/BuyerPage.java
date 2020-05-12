package view;

import controller.BuyerControl;
import models.Discount;
import view.usersPageCommands.BuyerCommands.ViewCart;
import view.usersPageCommands.BuyerCommands.ViewOrders;
import view.usersPageCommands.PersonalInfo;

public class BuyerPage extends Page {
    public BuyerPage(Page parentPage) {
        super(parentPage,"your account(buyer)");
        subPages.put("view personal info",new PersonalInfo(this));
        subPages.put("view cart",new ViewCart(this));
        subPages.put("view orders",new ViewOrders(this));
        subPages.put("view balance", ViewBalance());
        subPages.put("view discount codes",ViewDiscountCodes());
    }



    protected Page ViewBalance(){
        return new Page(this,"view balance") {
            @Override
            public void execute() {
                System.out.println( Page.getAccount().getCredit());
                new Back(this).execute();
            }
        };
    }

    protected Page ViewDiscountCodes(){
        return new Page(this, " view discount code") {
            @Override
            public void execute() {
                for (Discount discount : BuyerControl.getDiscountByAccount(Page.getAccount())) {
                    System.out.println(discount.getDiscountCode());
                }
                new Back(this).execute();
            }
        };
    }
}
