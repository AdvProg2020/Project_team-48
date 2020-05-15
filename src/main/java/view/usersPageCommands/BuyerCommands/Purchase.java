package view.usersPageCommands.BuyerCommands;

import controller.BuyerControl;
import models.Buyer;
import models.Discount;
import models.Product;
import view.Back;
import view.Page;

import java.sql.ParameterMetaData;

public class Purchase extends Page {

    private Discount discount = null;

    public Purchase(Page parentPage) {
        super(parentPage, "purchase");
        subPages.put("receiver information", ReceiverInformation());
    }

    @Override
    public void execute() {
        ReceiverInformation().execute();
    }

    protected Page ReceiverInformation() {
        return new Page(this, "receiver information") {
            @Override
            public void execute() {
                subPages.put("discount code", DiscountCode());
                System.out.println("enter your address");
                Page.getAccount().setAddress(scanner.nextLine());
                DiscountCode().execute();
            }
        };
    }

    protected Page DiscountCode() {
        return new Page(this, "discount code") {
            @Override
            public void execute() {
                subPages.put("payment", Payment());
                System.out.println("Do you have discount code");
                if (scanner.nextLine().equals("yes")) {
                    int code = Integer.parseInt(scanner.nextLine());
                    if (BuyerControl.checkDiscount(Page.getAccount(), Discount.getDiscountByCode(code))) {
                        discount = Discount.getDiscountByCode(code);
                    }
                }
                Payment().execute();
            }
        };
    }

    protected Page Payment() {
        return new Page(this, "payment") {
            @Override
            public void execute() {
                System.out.println("Do you want to complete purchase?");
                String input = scanner.nextLine();
                if (input.equals("yes")) {
                    if (BuyerControl.purchase(Page.getAccount(), discount)) {
                        System.out.println("your action was successful");
                        this.getParentPage().getParentPage().getParentPage().getParentPage().execute();
                    } else {
                        System.out.println("you do not have enough credit");
                        new Back(this).execute();
                    }
                } else if (input.equals("no")) {
                    new Back(this).execute();
                }
            }
        };
    }
}
