package models;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayList;
import java.util.Date;

public class Discount{
    private int discountCode;
    private String startDate;
    private String finishDate;
    private int discountPercent;
    private int repeat;
    private ArrayList<Account> allDiscountedUsers = new ArrayList<>();
    private static ArrayList<Discount> allDiscounts = new ArrayList<>();

    public Discount(int discountCode, String startDate, String finishDate, int discountPercent, int repeat, ArrayList<Account> allDiscountedUsers) {
        this.discountCode = discountCode;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.discountPercent = discountPercent;
        this.repeat = repeat;
        this.allDiscountedUsers = allDiscountedUsers;
        allDiscounts.add(this);
    }

    public static ArrayList<Discount> getAllDiscounts() {
        return allDiscounts;
    }

    public int getDiscountCode() {
        return discountCode;
    }

    public static Discount getDiscountByCode(int code){
        for (Discount discount : allDiscounts) {
            if (discount.getDiscountCode()==code){
                return discount;
            }
        }
        return null;
    }

    public static boolean existCode(int code){
        for (Discount discount : allDiscounts) {
            if (discount.discountCode==code){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return
                "discountCode=" + discountCode+ "\n"+
                "   startDate=" + startDate + "\n" +
                "   finishDate=" + finishDate + "\n" +
                "   discountPercent=" + discountPercent+ "\n" +
                "   repeat=" + repeat + "\n"+
                "   allDiscountedUsers=" + allDiscountedUsers + "\n"
                ;
    }

    public void setDiscountCode(int discountCode) {
        this.discountCode = discountCode;
    }

    public static void remove(int code){
        allDiscounts.remove(getDiscountByCode(code));
    }
}