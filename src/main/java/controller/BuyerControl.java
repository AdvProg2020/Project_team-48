package controller;

import models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BuyerControl {
    public static boolean checkDiscount(Account account, Discount discount) {
        Buyer buyer = (Buyer) account;
        if (discount.getStartDate().isBefore(LocalDate.now()) && discount.getFinishDate().isAfter(LocalDate.now())) {
            return discount.getAllDiscountedUsers().contains(buyer);
        }
        return false;
    }


    public static boolean purchase(Account account, Discount discount) {
        Buyer buyer = (Buyer) account;
        int price = buyer.getCart().getTotalPrice();
        if (discount != null) {
            if (discount.getStartDate().isBefore(LocalDate.now()) && discount.getFinishDate().isAfter(LocalDate.now())) {
                for (Account user : discount.getAllDiscountedUsers()) {
                    if (account == user) {
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
            BuyLog buyLog;
            if (discount != null) {
                buyLog = new BuyLog(((Buyer) account).getCart().getProducts(), discount.getDiscountPercent(), (Buyer) account);
            } else {
                buyLog = new BuyLog(((Buyer) account).getCart().getProducts(), 0, (Buyer) account);
            }
            ((Buyer) account).addBuyLog(buyLog);
            Account buyerAccount = account;
            buyerAccount.addBuyLog(buyLog);

            for (Product product : ((Buyer) account).getCart().getProducts()) {
                product.getSeller().setCredit(product.getSeller().getCredit() + product.getPrice());
                product.setExisting(product.getExisting() - 1);
                product.addBuyers(account);
                Account sellerAccount = product.getSeller();
                sellerAccount.addSellLog(new SellLog(product, LocalDateTime.now(), ((Buyer) account)));
            }
            ((Buyer) account).getCart().clear();
            return true;
        }
        return false;
    }

    public static ArrayList<Discount> getDiscountByAccount(Account account) {
        ArrayList<Discount> dis = new ArrayList<>();
        for (Discount discount : Discount.getAllDiscounts()) {
            for (Account user : discount.getAllDiscountedUsers()) {
                if (user == account) {
                    dis.add(discount);
                }
            }
        }
        return dis;
    }
}
