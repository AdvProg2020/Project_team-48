package controller;

import models.*;
import view.Page;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class BuyerControl {
    public static boolean checkDiscount(Account account, Discount discount) {
        Buyer buyer = (Buyer) account;
        if (checkDate(discount.getStartDate(), discount.getFinishDate())) {
            if (discount.getAllDiscountedUsers().contains(account)) {
                return true;
            }

        }
        return false;
    }

    public static boolean checkDate(String start, String end) {
        return true;////////////////////////////////////////////////////////////////////////////////
    }

    public static boolean purchase(Account account, Discount discount) {
        Buyer buyer = (Buyer) account;
        int price = buyer.getCart().getTotalPrice();
        if (discount != null) {
            if (discount.getMax() > price * discount.getDiscountPercent() / 100) {
                price = price - (int) ((price * discount.getDiscountPercent()) / 100);
            } else {
                price = price - discount.getMax();
            }
        }
        if (account.getCredit() >= price) {
            account.setCredit(account.getCredit() - price);
            new BuyLog(((Buyer) account).getCart().getProducts(),discount.getDiscountPercent(), (Buyer) account);
            ((Buyer) account).getCart().clear();
            discount.decreaseRepeat(account);
            return true;
        }
        return false ;
    }

    public static ArrayList<Discount> getDiscountByAccount(Account account){
        ArrayList <Discount> dis = new ArrayList<>();
        for (Discount discount : Discount.getAllDiscounts()) {
            for (Account user : discount.getAllDiscountedUsers()) {
                if (user == account){
                    dis.add(discount);
                }
            }
        }
        return dis;
    }
}
