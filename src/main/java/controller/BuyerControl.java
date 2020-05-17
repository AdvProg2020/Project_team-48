package controller;

import models.*;
import view.Page;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class BuyerControl {
    public static boolean checkDiscount(Account account, Discount discount) {
        Buyer buyer = (Buyer) account;
        if (discount.getStartDate().isBefore(LocalDateTime.now()) && discount.getFinishDate().isAfter(LocalDateTime.now())) {
            if (discount.getAllDiscountedUsers().contains(account)) {
                return true;
            }

        }
        return false;
    }


    public static boolean purchase(Account account, Discount discount) {
        Buyer buyer = (Buyer) account;
        int price = buyer.getCart().getTotalPrice();
        if (discount != null) {
            if (discount.getStartDate().isBefore(LocalDateTime.now()) && discount.getFinishDate().isAfter(LocalDateTime.now())){
                for (Account user : discount.getAllDiscountedUsers()) {
                    if (account == user){
                        if (discount.getMax() > price * discount.getDiscountPercent() / 100) {
                            price = price - (int) ((price * discount.getDiscountPercent()) / 100);
                        } else {
                            price = price - discount.getMax();
                        }
                    }
                }
            }

        }
        if (account.getCredit() >= price) {
            account.setCredit(account.getCredit() - price);
            ((Buyer)account).addBuyLog(new BuyLog(((Buyer) account).getCart().getProducts(),discount.getDiscountPercent(), (Buyer) account));

            for (Product product : ((Buyer) account).getCart().getProducts()) {
                product.getSeller().setCredit(product.getSeller().getCredit() + product.getPrice());
                product.setExisting(product.getExisting()-1);
                product.addBuyers(account);
                new SellLog(product , LocalDateTime.now() ,((Buyer)account));
            }
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
