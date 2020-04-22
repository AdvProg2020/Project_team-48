package view;

import view.usersPageCommands.BuyerCommands.ViewCart;
import view.usersPageCommands.BuyerCommands.ViewOrders;
import view.usersPageCommands.PersonalInfo;

import java.util.HashMap;

public class BuyerPage extends Page {
    public BuyerPage(Page parentPage) {
        super( parentPage);
        subPages.put("view\\spersonal\\sinfo",new PersonalInfo(this));
        subPages.put("view\\scart",new ViewCart(this));
        subPages.put("purchase",Purchase());
        subPages.put("view\\sorders",new ViewOrders(this));
        subPages.put("view\\sbalance",ViewBalance());
        subPages.put("view\\sdiscount\\scodes",ViewDiscountCodes());
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
