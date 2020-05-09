package view;

import view.usersPageCommands.BuyerCommands.ViewCart;
import view.usersPageCommands.BuyerCommands.ViewOrders;
import view.usersPageCommands.PersonalInfo;

import java.util.HashMap;

public class BuyerPage extends Page {
    public BuyerPage(Page parentPage) {
        super(parentPage);
        this.name = "your account";
        subPages.put("view personal info",new PersonalInfo(this));
        subPages.put("view cart",new ViewCart(this));
        subPages.put("purchase", Purchase());
        subPages.put("view orders",new ViewOrders(this));
        subPages.put("view balance", ViewBalance());
        subPages.put("view discount codes",ViewDiscountCodes());
        subPages.put("back",new Back(this));
    }


    protected Page Purchase(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ViewBalance(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }

    protected Page ViewDiscountCodes(){
        return new Page(this) {
            @Override
            public void execute() {

            }
        };
    }
}
