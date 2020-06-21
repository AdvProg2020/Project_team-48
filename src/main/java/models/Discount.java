package models;

import com.google.gson.internal.$Gson$Preconditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Handler;

public class Discount {
    private int discountCode;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private int max;
    private int discountPercent;
    private HashMap<Account, Integer> repeat = new HashMap<>();
    private ArrayList<Account> allDiscountedUsers = new ArrayList<>();
    private static ArrayList<Discount> allDiscounts = new ArrayList<>();

    public Discount(int discountCode, String startDate, String finishDate, int discountPercent, int repeat, ArrayList<Account> allDiscountedUsers, int max) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.discountCode = discountCode;
        this.startDate = LocalDateTime.parse(startDate, formatter);
        this.finishDate = LocalDateTime.parse(finishDate, formatter);
        this.discountPercent = discountPercent;
        this.allDiscountedUsers = allDiscountedUsers;
        for (Account user : allDiscountedUsers) {
            this.repeat.put(user, repeat);
        }
        allDiscounts.add(this);
        this.max = max;
    }

    public ArrayList<Account> getAllDiscountedUsers() {
        return allDiscountedUsers;
    }

    public int getMax() {
        return max;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public static ArrayList<Discount> getAllDiscounts() {
        return allDiscounts;
    }

    public int getDiscountCode() {
        return discountCode;
    }

    public static Discount getDiscountByCode(int code) {
        for (Discount discount : allDiscounts) {
            if (discount.getDiscountCode() == code) {
                return discount;
            }
        }
        return null;
    }

    public static boolean existCode(int code) {
        for (Discount discount : allDiscounts) {
            if (discount.discountCode == code) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return
                "discountCode=" + discountCode + "\n" +
                        "   startDate=" + startDate + "\n" +
                        "   finishDate=" + finishDate + "\n" +
                        "   discountPercent=" + discountPercent + "\n" +
                        "   repeat=" + repeat + "\n" +
                        "   allDiscountedUsers=" + allDiscountedUsers + "\n"
                ;
    }

    public static void remove(int code) {
        allDiscounts.remove(getDiscountByCode(code));
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void decreaseRepeat(Account account) {
        for (Account account1 : repeat.keySet()) {
            if (account == account1) {
                int rep = repeat.get(account);
                repeat.replace(account, rep);
            }
        }
    }

    public void setStartDate(String startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.startDate = LocalDateTime.parse(startDate, formatter);
    }

    public void setFinishDate(String finishDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        this.finishDate = LocalDateTime.parse(finishDate, formatter);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

}